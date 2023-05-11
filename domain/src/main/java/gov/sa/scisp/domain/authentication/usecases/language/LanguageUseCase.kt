package gov.sa.scisp.domain.authentication.usecases.language

import gov.sa.scisp.domain.authentication.repositories.language.LanguageRepository
import gov.sa.scisp.domain.authentication.repositories.login.LoginRepository
import gov.sa.scisp.domain.authentication.requests.language.LanguageRequest
import gov.sa.scisp.domain.authentication.requests.login.UserLoginRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class LanguageUseCase(
    private val languageRepository: LanguageRepository,
    private val dispatcher: CoroutineDispatcher
) : KoinComponent {
    suspend operator fun invoke(languageRequest: LanguageRequest) =
        withContext(dispatcher) {
            languageRepository.getLanguages(languageRequest)
        }
}