package gov.sa.scisp.di

import gov.sa.scisp.data.network.di.retrofitModule
import gov.sa.scisp.data.network.service.authentication.LanguageApiService
import gov.sa.scisp.data.network.service.authentication.LoginApiService
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val servicesModule = module {
    includes(retrofitModule)

    single<LanguageApiService> { get<Retrofit>().create(LanguageApiService::class.java) }
    single<LoginApiService> { get<Retrofit>().create(LoginApiService::class.java) }
}