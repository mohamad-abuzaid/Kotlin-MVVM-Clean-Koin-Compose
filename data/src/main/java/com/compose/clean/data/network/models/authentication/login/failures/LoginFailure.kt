package com.compose.clean.data.network.models.authentication.login.failures

import com.compose.clean.domain.utils.wrappers.CallFailure
import com.compose.clean.domain.utils.wrappers.error_code.LoginErrorCodes

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class LoginFailure(errors: Int) : CallFailure() {

    init {
        val errorMessages = mutableListOf<Int>()
        fun add(message: Int) = errorMessages.add(message)

        when (errors) {
            LoginErrorCodeEnum.SUCCESS.code -> {
                add(LoginErrorCodes.SUCCESS)
            }

            LoginErrorCodeEnum.INTERNAL_SERVER_ERROR.code -> {
                add(LoginErrorCodes.INTERNAL_SERVER_ERROR)
            }

            else -> add(LoginErrorCodes.UNKOWN_ERROR)
        }

        errorIds = errorMessages
    }
}




