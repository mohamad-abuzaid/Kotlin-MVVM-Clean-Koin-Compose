package gov.sa.scisp.viewmodels.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import gov.sa.scisp.domain.authentication.requests.language.LanguageRequest
import gov.sa.scisp.domain.authentication.requests.login.UserLoginRequest
import gov.sa.scisp.domain.authentication.requests.login.VipLoginRequest
import gov.sa.scisp.domain.authentication.requests.login.VvipLoginRequest
import gov.sa.scisp.domain.authentication.usecases.language.LanguageUseCase
import gov.sa.scisp.domain.authentication.usecases.login.UserLoginUseCase
import gov.sa.scisp.domain.authentication.usecases.login.VipLoginUseCase
import gov.sa.scisp.domain.authentication.usecases.login.VvipLoginUseCase
import gov.sa.scisp.domain.utils.wrappers.error_code.CallErrorCodes
import gov.sa.scisp.models.authentication.languages.mappers.toLanguageDisplayList
import gov.sa.scisp.models.authentication.login.mappers.toLoginDisplay
import gov.sa.scisp.viewmodels.authentication.states.LanguageUiState
import gov.sa.scisp.viewmodels.authentication.states.LoginUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class AuthenticationViewModel(
    application: Application,
    private val languageUseCase: LanguageUseCase,
    private val userLoginUseCase: UserLoginUseCase,
    private val vipLoginUseCase: VipLoginUseCase,
    private val vvipLoginUseCase: VvipLoginUseCase,
) : AndroidViewModel(application) {

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
     val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    private val _languageUiState = MutableStateFlow<LanguageUiState>(LanguageUiState.Idle)
     val languageUiState: StateFlow<LanguageUiState> = _languageUiState.asStateFlow()

    private var loginJob: Job? = null
     fun userLogin(nin: String) {
        loginJob?.cancel()
        loginJob = viewModelScope.launch {
            _loginUiState.value = LoginUiState.Loading
            try {
                val loginResponse = userLoginUseCase(UserLoginRequest(nin))
                if (loginResponse.error == null) {
                    _loginUiState.value =
                        LoginUiState.Success(loginResponse.value?.toLoginDisplay())
                } else {
                    _loginUiState.value =
                        LoginUiState.Error(loginResponse.error?.errorIds?.toList() ?: listOf())
                }
            } catch (ioe: IOException) {
                _loginUiState.value = LoginUiState.Error(listOf(CallErrorCodes.UNKOWN_ERROR))
            }
        }
    }

     fun vipLogin(username: String, password: String) {
        loginJob?.cancel()
        loginJob = viewModelScope.launch {
            _loginUiState.value = LoginUiState.Loading
            try {
                val loginResponse = vipLoginUseCase(VipLoginRequest(username, password))
                if (loginResponse.error == null) {
                    _loginUiState.value =
                        LoginUiState.Success(loginResponse.value?.toLoginDisplay())
                } else {
                    _loginUiState.value =
                        LoginUiState.Error(loginResponse.error?.errorIds?.toList() ?: listOf())
                }
            } catch (ioe: IOException) {
                _loginUiState.value = LoginUiState.Error(listOf(CallErrorCodes.UNKOWN_ERROR))
            }
        }
    }

     fun vvipLogin(username: String, password: String) {
        loginJob?.cancel()
        loginJob = viewModelScope.launch {
            _loginUiState.value = LoginUiState.Loading
            try {
                val loginResponse = vvipLoginUseCase(VvipLoginRequest(username, password))
                if (loginResponse.error == null) {
                    _loginUiState.value =
                        LoginUiState.Success(loginResponse.value?.toLoginDisplay())
                } else {
                    _loginUiState.value =
                        LoginUiState.Error(loginResponse.error?.errorIds?.toList() ?: listOf())
                }
            } catch (ioe: IOException) {
                _loginUiState.value = LoginUiState.Error(listOf(CallErrorCodes.UNKOWN_ERROR))
            }
        }
    }

     fun fetchLanguages(nin: String) {
        viewModelScope.launch {
            _languageUiState.value = LanguageUiState.Loading
            try {
                val languageResponse = languageUseCase(LanguageRequest(nin))
                if (languageResponse.error == null) {
                    _languageUiState.value =
                        LanguageUiState.Success(languageResponse.value?.toLanguageDisplayList())
                } else {
                    _languageUiState.value =
                        LanguageUiState.Error(languageResponse.error?.errorIds?.toList() ?: listOf())
                }
            } catch (ioe: IOException) {
                _languageUiState.value = LanguageUiState.Error(listOf(CallErrorCodes.UNKOWN_ERROR))
            }
        }
    }
}