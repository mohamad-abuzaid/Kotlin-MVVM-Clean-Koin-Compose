package gov.sa.scisp.domain.authentication.repositories.language

import gov.sa.scisp.domain.authentication.models.login.LanguageModel
import gov.sa.scisp.domain.authentication.requests.language.LanguageRequest
import gov.sa.scisp.domain.utils.wrappers.CallFailure
import gov.sa.scisp.domain.utils.wrappers.ServiceCallResult

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface LanguageRepository {
    suspend fun getLanguages(languageRequest: LanguageRequest): ServiceCallResult<List<LanguageModel>, CallFailure>
}