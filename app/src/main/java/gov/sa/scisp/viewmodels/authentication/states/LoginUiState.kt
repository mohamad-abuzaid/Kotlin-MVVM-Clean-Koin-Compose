package gov.sa.scisp.viewmodels.authentication.states

import gov.sa.scisp.models.authentication.login.LoginDisplay

/**
 * Created by "Mohamad Abuzaid" on 07/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val loggedUser: LoginDisplay?) : LoginUiState()
    data class Error(val messages: List<Int>) : LoginUiState()
}