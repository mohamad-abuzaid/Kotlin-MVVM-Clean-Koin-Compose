package gov.sa.scisp.data.network.factory

import gov.sa.scisp.domain.utils.wrappers.error_code.CallErrorCodes
import gov.sa.scisp.domain.utils.wrappers.CallFailure
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class UnAuthorizedAccess : CallFailure() {
    init {
        errorIds = mutableListOf(CallErrorCodes.UNAUTHORIZED_ACCESS)
    }
}

class ServiceUnAvailable : CallFailure() {
    init {
        errorIds = mutableListOf(CallErrorCodes.SERVICE_UNAVAILABLE)
    }
}

class TimeOut : CallFailure() {
    init {
        errorIds = mutableListOf(CallErrorCodes.TIMEOUT)
    }
}

class InvalidInput : CallFailure() {
    init {
        errorIds = mutableListOf(CallErrorCodes.INVALID_INPUT)
    }
}

class ServerError : CallFailure() {
    init {
        errorIds = mutableListOf(CallErrorCodes.SERVER_ERROR)
    }
}

class ConnectionError : CallFailure() {
    init {
        errorIds = mutableListOf(CallErrorCodes.CONNECTION_ERROR)
    }
}

class UnKnownError : CallFailure() {
    init {
        errorIds = mutableListOf(CallErrorCodes.UNKOWN_ERROR)
    }
}

object MapThrowableToCallFailure {
    fun map(throwable: Throwable): CallFailure {
        try {
            when (throwable) {
                is HttpException -> {
                    val httpException: HttpException = throwable
                    return when (val code: Int = httpException.code()) {
                        401 -> UnAuthorizedAccess()
                        503 -> ServiceUnAvailable()
                        400 -> InvalidInput()
                        500 -> ServerError()
                        else -> UnKnownError()
                    }
                }

                is SocketTimeoutException -> {
                    return TimeOut()
                }

                is UnknownHostException -> {
                    return ConnectionError()
                }

                is IOException -> {
                    return ConnectionError()
                }

                else -> {
                    return UnKnownError()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return UnKnownError()
        } /*finally {
            try {
                FirebaseCrashlytics.getInstance().recordException(throwable)
            } catch (e: Exception)
        }*/
    }
}