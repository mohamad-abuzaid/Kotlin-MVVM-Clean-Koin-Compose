package gov.sa.scisp.data.network.models.login.failures

import gov.sa.scisp.domain.utils.wrappers.CallFailure
import gov.sa.scisp.domain.utils.wrappers.error_code.LoginErrorCodes

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




