package gov.sa.scisp.data.network.models.languages.failures

import gov.sa.scisp.domain.utils.wrappers.CallFailure
import gov.sa.scisp.domain.utils.wrappers.error_code.LanguageErrorCodes

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class LanguageFailure(errors: Int) : CallFailure() {

    init {
        val errorMessages = mutableListOf<Int>()
        fun add(message: Int) = errorMessages.add(message)

        when (errors) {
            LanguageErrorCodeEnum.SUCCESS.code -> {
                add(LanguageErrorCodes.SUCCESS)
            }

            LanguageErrorCodeEnum.INTERNAL_SERVER_ERROR.code -> {
                add(LanguageErrorCodes.INTERNAL_SERVER_ERROR)
            }

            else -> add(LanguageErrorCodes.UNKOWN_ERROR)
        }

        errorIds = errorMessages
    }
}




