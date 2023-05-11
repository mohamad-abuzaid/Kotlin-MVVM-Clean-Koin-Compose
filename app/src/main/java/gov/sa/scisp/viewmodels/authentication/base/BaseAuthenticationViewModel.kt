package gov.sa.scisp.viewmodels.authentication.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import gov.sa.scisp.viewmodels.authentication.states.LanguageUiState
import gov.sa.scisp.viewmodels.authentication.states.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Created by "Mohamad Abuzaid" on 08/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
abstract class BaseAuthenticationViewModel(application: Application) :
    AndroidViewModel(application) {
    abstract val loginUiState: StateFlow<LoginUiState>
    abstract val languageUiState: StateFlow<LanguageUiState>

    abstract fun userLogin(nin: String)
    abstract fun vipLogin(username: String, password: String)
    abstract fun vvipLogin(username: String, password: String)
    abstract fun fetchLanguages(nin: String)
}

/************** Preview ViewModel **************/
class PreviewAuthenticationViewModel(application: Application = Application()) :
    BaseAuthenticationViewModel(application) {

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    override val loginUiState: StateFlow<LoginUiState> = _loginUiState

    private val _languageUiState = MutableStateFlow<LanguageUiState>(LanguageUiState.Idle)
    override val languageUiState: StateFlow<LanguageUiState> = _languageUiState

    override fun userLogin(nin: String) {}
    override fun vipLogin(username: String, password: String) {}
    override fun vvipLogin(username: String, password: String) {}
    override fun fetchLanguages(nin: String) {}
}