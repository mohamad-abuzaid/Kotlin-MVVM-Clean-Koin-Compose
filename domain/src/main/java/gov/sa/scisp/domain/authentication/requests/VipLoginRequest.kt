package gov.sa.scisp.domain.authentication.requests

import com.google.gson.annotations.SerializedName

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
data class VipLoginRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)