package gov.sa.scisp.data.storage

/**
 * Created by "Mohamad Abuzaid" on 06/08/2023.
 * Email: mabuzaid@sure.com.sa
 */
import gov.sa.scisp.data.network.models.authentication.token.TokenRemote
import gov.sa.scisp.data.network.service.authentication.TokenApiService
import gov.sa.scisp.domain.main.token.ITokenManager
import gov.sa.scisp.domain.utils.storage.ILocalPreferencesStorage
import gov.sa.scisp.domain.utils.storage.Preference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TokenManager(
    private val prefs: ILocalPreferencesStorage
) : ITokenManager, KoinComponent {
    private val apiService: TokenApiService by inject()

    private val _logoutRequired = MutableStateFlow(false)
    override val logoutRequired: StateFlow<Boolean> = _logoutRequired.asStateFlow()

    override fun getToken(): String {
        return prefs.getString(Preference.USER_TOKEN, "")
    }

    private fun getRefreshToken(): String {
        return prefs.getString(Preference.USER_REFRESH_TOKEN, "")
    }

    @Synchronized
    override fun fetchNewAccessToken(): String? {
        val refreshToken = getRefreshToken()
        val expiredToken = getToken()

        if (refreshToken.isEmpty()) {
            logout()
            return null
        }

        val response = apiService.refreshToken(TokenRemote(refreshToken, expiredToken)).execute()

        return response.body()?.let {
            if (it.success) {
                saveToken(it.data.accessToken)
                saveRefreshToken(it.data.refreshToken)

                it.data.accessToken
            } else {
                logout()
                null
            }
        } ?: run {
            logout()
            null
        }
    }

    private fun saveToken(token: String) {
        prefs.putString(Preference.USER_TOKEN, token)
    }

    private fun saveRefreshToken(refreshToken: String) {
        prefs.putString(Preference.USER_REFRESH_TOKEN, refreshToken)
    }

    override fun logout() {
        prefs.clearToken()
        _logoutRequired.value = true
    }

    override fun resetTokenState() {
        _logoutRequired.value = false
    }
}