package gov.sa.scisp.data.network.models.login.response
import com.google.gson.annotations.SerializedName

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
data class LoginRemote(
    @SerializedName("username")
    val username: String,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String
)