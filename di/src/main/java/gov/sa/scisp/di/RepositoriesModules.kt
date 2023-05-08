package gov.sa.scisp.di

import gov.sa.scisp.data.repositories.authentication.LoginRepositoryImpl
import gov.sa.scisp.domain.authentication.repositories.LoginRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val repositoriesModule = module {
    single<LoginRepository> {
        LoginRepositoryImpl(
            loginApiService = get(),
            dispatcher = get(named("ioDispatcher"))
        )
    }
}