package gov.sa.scisp.viewmodels.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import gov.sa.scisp.states.authentication.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by "Mohamad Abuzaid" on 08/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
abstract class BaseAuthenticationViewModel(application: Application) : AndroidViewModel(application) {
    abstract val loginUiState: StateFlow<LoginUiState>

    abstract fun userLogin(nin: String)
    abstract fun vipLogin(username: String, password: String)
    abstract fun vvipLogin(username: String, password: String)
}

/************** Preview ViewModel **************/
class PreviewAuthenticationViewModel(application: Application = Application()) :
    BaseAuthenticationViewModel(application) {

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    override val loginUiState: StateFlow<LoginUiState> = _loginUiState

    override fun userLogin(nin: String) {
        //TODO("Not yet implemented")
    }

    override fun vipLogin(username: String, password: String) {
        //TODO("Not yet implemented")
    }

    override fun vvipLogin(username: String, password: String) {
        //TODO("Not yet implemented")
    }
}