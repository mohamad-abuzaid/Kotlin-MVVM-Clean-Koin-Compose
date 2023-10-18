package com.compose.clean.data.repositories.authentication.languages

import com.compose.clean.data.network.factory.MapThrowableToCallFailure
import com.compose.clean.data.network.models.authentication.languages.failures.LanguageFailure
import com.compose.clean.data.network.models.authentication.languages.mappers.toLanguageModelList
import com.compose.clean.data.network.service.authentication.LanguageApiService
import com.compose.clean.domain.authentication.models.login.LanguageModel
import com.compose.clean.domain.authentication.repositories.language.LanguageRepository
import com.compose.clean.domain.authentication.requests.language.LanguageRequest
import com.compose.clean.domain.utils.wrappers.CallFailure
import com.compose.clean.domain.utils.wrappers.ServiceCallResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class LanguageRepositoryImpl(
    private val languageApiService: LanguageApiService,
    private val dispatcher: CoroutineDispatcher
) : LanguageRepository {

    override suspend fun getLanguages(languageRequest: LanguageRequest): ServiceCallResult<List<LanguageModel>, CallFailure> {
        return try {
            withContext(dispatcher) {
                val result = languageApiService.getLanguages(languageRequest)
                if (result.errorCode == 0)
                    ServiceCallResult(value = result.data.toLanguageModelList())
                else
                    ServiceCallResult(
                        error = LanguageFailure((result.errorCode)),
                        value = null
                    )
            }

        } catch (e: Exception) {
            ServiceCallResult(error = MapThrowableToCallFailure.map(e))
        }
    }


//    TODO: Uncomment this code to save chatbot responses to database
//            .also {
//                if (it is AskChatbotResult.Success) {
//                    chatbotResponsesDatabase.chatbotResponsesDao().insertAll(*it.data)
//                }
//            }
}