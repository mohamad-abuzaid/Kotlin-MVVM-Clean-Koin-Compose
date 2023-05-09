package gov.sa.scisp.domain.authentication.usecases

import gov.sa.scisp.domain.authentication.repositories.LoginRepository
import gov.sa.scisp.domain.authentication.requests.VipLoginRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class VipLoginUseCase(
    private val loginRepository: LoginRepository,
    private val dispatcher: CoroutineDispatcher
) : KoinComponent {
    suspend operator fun invoke(vipLoginRequest: VipLoginRequest) =
        withContext(dispatcher) {
            loginRepository.vipLogin(vipLoginRequest)
        }
}