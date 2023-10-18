package com.compose.clean.data.network.service.authentication

import com.compose.clean.data.network.models.authentication.token.TokenRemote
import com.compose.clean.data.network.models.wrapper.RemoteResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by "Mohamad Abuzaid" on 06/08/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface TokenApiService {

    @POST("api/Account/RefreshToken")
    fun refreshToken(@Body tokenRemote: TokenRemote): Call<RemoteResponse<TokenRemote>>
}