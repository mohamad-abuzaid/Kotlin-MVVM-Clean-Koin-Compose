package gov.sa.scisp.data.network.service

import gov.sa.scisp.data.network.models.languages.response.LanguageRemote
import gov.sa.scisp.data.network.models.wrapper.RemoteResponse
import gov.sa.scisp.domain.authentication.requests.language.LanguageRequest
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