package gov.sa.scisp.domain.authentication.requests.language
import com.google.gson.annotations.SerializedName

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
data class LanguageRequest(
    @SerializedName("nin")
    val nin: String
)