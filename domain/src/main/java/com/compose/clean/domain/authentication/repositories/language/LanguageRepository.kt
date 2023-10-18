package com.compose.clean.domain.authentication.repositories.language

import com.compose.clean.domain.authentication.models.login.LanguageModel
import com.compose.clean.domain.authentication.requests.language.LanguageRequest
import com.compose.clean.domain.utils.wrappers.CallFailure
import com.compose.clean.domain.utils.wrappers.ServiceCallResult

/**
 * Created by "Mohamad Abuzaid" on 10/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface LanguageRepository {
    suspend fun getLanguages(languageRequest: LanguageRequest): ServiceCallResult<List<LanguageModel>, CallFailure>
}