package gov.sa.scisp.domain.utils.wrappers

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
data class ServiceCallResult<T, E>(val value: T? = null, val error: E? = null)