package gov.sa.scisp.viewmodels.authentication

import android.app.Application
import androidx.lifecycle.viewModelScope
import gov.sa.scisp.domain.authentication.requests.UserLoginRequest
import gov.sa.scisp.domain.authentication.requests.VipLoginRequest
import gov.sa.scisp.domain.authentication.requests.VvipLoginRequest
import gov.sa.scisp.domain.authentication.usecases.UserLoginUseCase
import gov.sa.scisp.domain.authentication.usecases.VipLoginUseCase
import gov.sa.scisp.domain.authentication.usecases.VvipLoginUseCase
import gov.sa.scisp.domain.utils.wrappers.CallErrorCodes
import gov.sa.scisp.models.mappers.toLoginDisplay
import gov.sa.scisp.states.authentication.LoginUiState
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
    private val userLoginUseCase: UserLoginUseCase,
    private val vipLoginUseCase: VipLoginUseCase,
    private val vvipLoginUseCase: VvipLoginUseCase,
) : BaseAuthenticationViewModel(application) {

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    override val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    private var loginJob: Job? = null
    override fun userLogin(nin: String) {
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

    override fun vipLogin(username: String, password: String) {
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

    override fun vvipLogin(username: String, password: String) {
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
}