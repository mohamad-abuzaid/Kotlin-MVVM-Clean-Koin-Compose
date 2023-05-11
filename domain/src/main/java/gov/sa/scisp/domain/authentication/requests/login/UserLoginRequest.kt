package gov.sa.scisp.domain.authentication.requests.login
import com.google.gson.annotations.SerializedName

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
data class UserLoginRequest(
    @SerializedName("nin")
    val nin: String
)