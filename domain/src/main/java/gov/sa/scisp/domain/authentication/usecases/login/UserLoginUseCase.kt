package gov.sa.scisp.domain.authentication.usecases.login

import gov.sa.scisp.domain.authentication.repositories.login.LoginRepository
import gov.sa.scisp.domain.authentication.requests.login.UserLoginRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class UserLoginUseCase(
    private val loginRepository: LoginRepository,
    private val dispatcher: CoroutineDispatcher
) : KoinComponent {
    suspend operator fun invoke(userLoginRequest: UserLoginRequest) =
        withContext(dispatcher) {
            loginRepository.userLogin(userLoginRequest)
        }
}