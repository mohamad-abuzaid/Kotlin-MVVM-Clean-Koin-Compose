package com.compose.clean.domain.utils.wrappers

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
open class CallFailure {
    var errorMessage: String? = null
    var errorMessageResId: Int? = null
    var errorCode: String? = null
    var responseCode: Int? = null
    var errorIds: MutableList<Int>? = null
}
