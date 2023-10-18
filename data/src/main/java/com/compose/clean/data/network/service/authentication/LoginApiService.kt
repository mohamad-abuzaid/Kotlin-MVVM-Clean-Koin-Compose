package com.compose.clean.data.network.service.authentication

import com.compose.clean.data.network.models.authentication.login.response.LoginRemote
import com.compose.clean.data.network.models.wrapper.RemoteResponse
import com.compose.clean.domain.authentication.requests.login.UserLoginRequest
import com.compose.clean.domain.authentication.requests.login.VipLoginRequest
import com.compose.clean.domain.authentication.requests.login.VvipLoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface LoginApiService {

    @POST("/user-login")
    suspend fun userLogin(@Body userLoginRequest: UserLoginRequest): RemoteResponse<LoginRemote>

    @POST("/vip-login")
    suspend fun vipLogin(@Body vipLoginRequest: VipLoginRequest): RemoteResponse<LoginRemote>

    @POST("/vvip-login")
    suspend fun vvipLogin(@Body vvipLoginRequest: VvipLoginRequest): RemoteResponse<LoginRemote>
}