package gov.sa.scisp.data.network.models.authentication.login.failures

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
enum class LoginErrorCodeEnum(val code: Int) {
    SUCCESS(0),
    INTERNAL_SERVER_ERROR(101)
}
