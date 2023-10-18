package com.compose.clean.data.network.service.authentication

import com.compose.clean.data.network.models.authentication.languages.response.LanguageRemote
import com.compose.clean.data.network.models.wrapper.RemoteResponse
import com.compose.clean.domain.authentication.requests.language.LanguageRequest
import retrofit2.http.Body
import retrofit2.http.GET

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface LanguageApiService {

    @GET("/get-languages")
    suspend fun getLanguages(@Body languageRequest: LanguageRequest): RemoteResponse<List<LanguageRemote>>
}