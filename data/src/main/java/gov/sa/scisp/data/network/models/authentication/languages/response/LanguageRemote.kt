package gov.sa.scisp.data.network.models.authentication.languages.response
import com.google.gson.annotations.SerializedName

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
data class LanguageRemote(
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
)