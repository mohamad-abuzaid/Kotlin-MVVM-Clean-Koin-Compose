package com.compose.clean.domain.main.token

import kotlinx.coroutines.flow.StateFlow


/**
 * Created by "Mohamad Abuzaid" on 02/09/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface ITokenManager {
    val logoutRequired: StateFlow<Boolean>
    fun getToken(): String
    fun fetchNewAccessToken(): String?
    fun logout()
    fun resetTokenState()
}