package gov.sa.scisp.domain.utils.wrappers

/**
 * Created by "Mohamad Abuzaid" on 07/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
object CallErrorCodes {
    const val UNAUTHORIZED_ACCESS = 101
    const val SERVICE_UNAVAILABLE = 102
    const val TIMEOUT = 103
    const val INVALID_INPUT = 104
    const val SERVER_ERROR = 105
    const val CONNECTION_ERROR = 106
    const val UNKOWN_ERROR = 107
}

object LoginErrorCodes {
    const val SUCCESS = 201
    const val INTERNAL_SERVER_ERROR = 202
    const val UNKOWN_ERROR = 203
}