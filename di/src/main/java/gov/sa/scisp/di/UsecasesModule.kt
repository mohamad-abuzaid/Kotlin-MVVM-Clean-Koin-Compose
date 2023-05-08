package gov.sa.scisp.di

import gov.sa.scisp.domain.authentication.usecases.UserLoginUseCase
import gov.sa.scisp.domain.authentication.usecases.VipLoginUseCase
import gov.sa.scisp.domain.authentication.usecases.VvipLoginUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val useCasesModule = module {
    factory {
        UserLoginUseCase(
            loginRepository = get(),
            dispatcher = get(named("defaultDispatcher"))
        )
    }
    factory {
        VipLoginUseCase(
            loginRepository = get(),
            dispatcher = get(named("defaultDispatcher"))
        )
    }
    factory {
        VvipLoginUseCase(
            loginRepository = get(),
            dispatcher = get(named("defaultDispatcher"))
        )
    }
}