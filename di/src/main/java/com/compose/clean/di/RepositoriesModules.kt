package com.compose.clean.di

import com.compose.clean.data.repositories.authentication.languages.LanguageRepositoryImpl
import com.compose.clean.data.repositories.authentication.login.LoginRepositoryImpl
import com.compose.clean.domain.authentication.repositories.language.LanguageRepository
import com.compose.clean.domain.authentication.repositories.login.LoginRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val repositoriesModule = module {
    single<LanguageRepository> {
        LanguageRepositoryImpl(
            languageApiService = get(),
            dispatcher = get(named("ioDispatcher"))
        )
    }

    single<LoginRepository> {
        LoginRepositoryImpl(
            loginApiService = get(),
            dispatcher = get(named("ioDispatcher"))
        )
    }
}