package gov.sa.scisp.data.network.service

import gov.sa.scisp.data.network.models.login.response.LoginRemote
import gov.sa.scisp.data.network.models.wrapper.RemoteResponse
import gov.sa.scisp.domain.authentication.requests.login.UserLoginRequest
import gov.sa.scisp.domain.authentication.requests.login.VipLoginRequest
import gov.sa.scisp.domain.authentication.requests.login.VvipLoginRequest
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