package com.compose.clean.di

import com.compose.clean.domain.authentication.usecases.language.LanguageUseCase
import com.compose.clean.domain.authentication.usecases.login.UserLoginUseCase
import com.compose.clean.domain.authentication.usecases.login.VipLoginUseCase
import com.compose.clean.domain.authentication.usecases.login.VvipLoginUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val useCasesModule = module {
    factory {
        LanguageUseCase(
            languageRepository = get(),
            dispatcher = get(named("defaultDispatcher"))
        )
    }
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