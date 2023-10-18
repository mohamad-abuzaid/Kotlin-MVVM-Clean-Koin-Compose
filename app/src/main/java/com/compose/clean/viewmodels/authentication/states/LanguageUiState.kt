package com.compose.clean.viewmodels.authentication.states

import com.compose.clean.models.authentication.languages.LanguageDisplay

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */

sealed class LanguageUiState {
    object Idle : LanguageUiState()
    object Loading : LanguageUiState()
    data class Success(val languages: List<LanguageDisplay>?) : LanguageUiState()
    data class Error(val messages: List<Int>) : LanguageUiState()
}