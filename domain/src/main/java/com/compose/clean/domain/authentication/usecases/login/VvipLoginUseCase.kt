package com.compose.clean.domain.authentication.usecases.login

import com.compose.clean.domain.authentication.repositories.login.LoginRepository
import com.compose.clean.domain.authentication.requests.login.VvipLoginRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class VvipLoginUseCase(
    private val loginRepository: LoginRepository,
    private val dispatcher: CoroutineDispatcher
) : KoinComponent {
    suspend operator fun invoke(vvipLoginRequest: VvipLoginRequest) =
        withContext(dispatcher) {
            loginRepository.vvipLogin(vvipLoginRequest)
        }
}