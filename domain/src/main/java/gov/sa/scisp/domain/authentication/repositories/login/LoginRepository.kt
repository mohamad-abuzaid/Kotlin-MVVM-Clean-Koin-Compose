package gov.sa.scisp.domain.authentication.repositories.login

import gov.sa.scisp.domain.authentication.models.login.LoginModel
import gov.sa.scisp.domain.authentication.requests.login.UserLoginRequest
import gov.sa.scisp.domain.authentication.requests.login.VipLoginRequest
import gov.sa.scisp.domain.authentication.requests.login.VvipLoginRequest
import gov.sa.scisp.domain.utils.wrappers.CallFailure
import gov.sa.scisp.domain.utils.wrappers.ServiceCallResult

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface LoginRepository {
    suspend fun userLogin(userLoginRequest: UserLoginRequest): ServiceCallResult<LoginModel, CallFailure>
    suspend fun vipLogin(vipLoginRequest: VipLoginRequest): ServiceCallResult<LoginModel, CallFailure>
    suspend fun vvipLogin(vvipLoginRequest: VvipLoginRequest): ServiceCallResult<LoginModel, CallFailure>
}