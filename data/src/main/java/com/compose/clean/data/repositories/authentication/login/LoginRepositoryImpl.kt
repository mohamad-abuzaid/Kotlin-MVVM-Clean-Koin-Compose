package com.compose.clean.data.repositories.authentication.login

import com.compose.clean.data.network.factory.MapThrowableToCallFailure
import com.compose.clean.data.network.models.authentication.login.failures.LoginFailure
import com.compose.clean.data.network.models.authentication.login.mappers.toLoginModel
import com.compose.clean.data.network.service.authentication.LoginApiService
import com.compose.clean.domain.authentication.models.login.LoginModel
import com.compose.clean.domain.authentication.repositories.login.LoginRepository
import com.compose.clean.domain.authentication.requests.login.UserLoginRequest
import com.compose.clean.domain.authentication.requests.login.VipLoginRequest
import com.compose.clean.domain.authentication.requests.login.VvipLoginRequest
import com.compose.clean.domain.utils.wrappers.CallFailure
import com.compose.clean.domain.utils.wrappers.ServiceCallResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class LoginRepositoryImpl(
    private val loginApiService: LoginApiService,
    private val dispatcher: CoroutineDispatcher
) : LoginRepository {

    override suspend fun userLogin(userLoginRequest: UserLoginRequest): ServiceCallResult<LoginModel, CallFailure> {
        return try {
            withContext(dispatcher) {
                val result = loginApiService.userLogin(userLoginRequest)
                if (result.errorCode == 0)
                    ServiceCallResult(value = result.data.toLoginModel())
                else
                    ServiceCallResult(
                        error = LoginFailure((result.errorCode)),
                        value = null
                    )
            }

        } catch (e: Exception) {
            ServiceCallResult(error = MapThrowableToCallFailure.map(e))
        }
    }

    override suspend fun vipLogin(vipLoginRequest: VipLoginRequest): ServiceCallResult<LoginModel, CallFailure> {
        return try {
            withContext(dispatcher) {
                val result = loginApiService.vipLogin(vipLoginRequest)
                if (result.errorCode == 0)
                    ServiceCallResult(value = result.data.toLoginModel())
                else
                    ServiceCallResult(
                        error = LoginFailure((result.errorCode)),
                        value = null
                    )
            }

        } catch (e: Exception) {
            ServiceCallResult(error = MapThrowableToCallFailure.map(e))
        }
    }

    override suspend fun vvipLogin(vvipLoginRequest: VvipLoginRequest): ServiceCallResult<LoginModel, CallFailure> {
        return try {
            withContext(dispatcher) {
                val result = loginApiService.vvipLogin(vvipLoginRequest)
                if (result.errorCode == 0)
                    ServiceCallResult(value = result.data.toLoginModel())
                else
                    ServiceCallResult(
                        error = LoginFailure((result.errorCode)),
                        value = null
                    )
            }

        } catch (e: Exception) {
            ServiceCallResult(error = MapThrowableToCallFailure.map(e))
        }
    }


//    TODO: Uncomment this code to save chatbot responses to database
//            .also {
//                if (it is AskChatbotResult.Success) {
//                    chatbotResponsesDatabase.chatbotResponsesDao().insertAll(*it.data)
//                }
//            }
}