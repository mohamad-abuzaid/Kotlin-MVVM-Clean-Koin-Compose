package com.compose.clean.domain.authentication.usecases.language

import com.compose.clean.domain.authentication.repositories.language.LanguageRepository
import com.compose.clean.domain.authentication.requests.language.LanguageRequest
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