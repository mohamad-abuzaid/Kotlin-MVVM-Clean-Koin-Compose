package com.compose.clean.data.network.models.authentication.token

import com.google.gson.annotations.SerializedName

/**
 * Created by "Mohamad Abuzaid" on 06/08/2023.
 * Email: mabuzaid@sure.com.sa
 */
data class TokenRemote(
    @SerializedName("refreshToken") val refreshToken: String,

    @SerializedName("accessToken") val accessToken: String
)