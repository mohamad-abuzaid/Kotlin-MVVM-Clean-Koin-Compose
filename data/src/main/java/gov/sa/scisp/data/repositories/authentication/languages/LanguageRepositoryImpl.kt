package gov.sa.scisp.data.repositories.authentication.languages

import gov.sa.scisp.data.network.factory.MapThrowableToCallFailure
import gov.sa.scisp.data.network.models.authentication.languages.failures.LanguageFailure
import gov.sa.scisp.data.network.models.authentication.languages.mappers.toLanguageModelList
import gov.sa.scisp.data.network.service.authentication.LanguageApiService
import gov.sa.scisp.domain.authentication.models.login.LanguageModel
import gov.sa.scisp.domain.authentication.repositories.language.LanguageRepository
import gov.sa.scisp.domain.authentication.requests.language.LanguageRequest
import gov.sa.scisp.domain.utils.wrappers.CallFailure
import gov.sa.scisp.domain.utils.wrappers.ServiceCallResult
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