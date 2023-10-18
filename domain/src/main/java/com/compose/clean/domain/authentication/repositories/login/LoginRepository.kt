package com.compose.clean.domain.authentication.repositories.login

import com.compose.clean.domain.authentication.models.login.LoginModel
import com.compose.clean.domain.authentication.requests.login.UserLoginRequest
import com.compose.clean.domain.authentication.requests.login.VipLoginRequest
import com.compose.clean.domain.authentication.requests.login.VvipLoginRequest
import com.compose.clean.domain.utils.wrappers.CallFailure
import com.compose.clean.domain.utils.wrappers.ServiceCallResult

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface LoginRepository {
    suspend fun userLogin(userLoginRequest: UserLoginRequest): ServiceCallResult<LoginModel, CallFailure>
    suspend fun vipLogin(vipLoginRequest: VipLoginRequest): ServiceCallResult<LoginModel, CallFailure>
    suspend fun vvipLogin(vvipLoginRequest: VvipLoginRequest): ServiceCallResult<LoginModel, CallFailure>
}