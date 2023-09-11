package gov.sa.scisp.data.network.interceptors

import gov.sa.scisp.domain.main.token.ITokenManager
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

/**
 * Created by "Mohamad Abuzaid" on 06/08/2023.
 * Email: mabuzaid@sure.com.sa
 */
class JWTAuthenticator(private val tokenManager: ITokenManager) : Authenticator {
    @Synchronized
    override fun authenticate(route: Route?, response: Response): Request? {
        // If we already tried to refresh the token and it still failed,
        // we redirect the user to the login screen.
        if (response.request.header("Authorization") != null) {
            tokenManager.logout()
            return null
        }

        // Try to refresh the token
        val newAccessToken = tokenManager.fetchNewAccessToken() ?: return null

        // Retry the request with the new token
        return response.request.newBuilder()
            .header("Authorization", "Bearer $newAccessToken")
            .build()
    }
}