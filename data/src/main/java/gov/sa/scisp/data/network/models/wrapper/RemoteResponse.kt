package gov.sa.scisp.data.network.models.wrapper
import com.google.gson.annotations.SerializedName

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
data class RemoteResponse<T>(
    @SerializedName("errorCode")
    val errorCode: Int,
    @SerializedName("data")
    val data: T
)