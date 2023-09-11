package gov.sa.scisp.viewmodels.main.token

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import gov.sa.scisp.domain.main.token.ITokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Created by "Mohamad Abuzaid" on 11/06/2023.
 * Email: mabuzaid@sure.com.sa
 */
class TokenViewModel(
    application: Application,
    tokenManager: ITokenManager,
) : AndroidViewModel(application) {

    private val _tokenState = MutableStateFlow(false)
    val tokenState: StateFlow<Boolean> = _tokenState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            tokenManager.logoutRequired.collect { shouldLogout ->
                _tokenState.value = shouldLogout
            }
        }
    }
}