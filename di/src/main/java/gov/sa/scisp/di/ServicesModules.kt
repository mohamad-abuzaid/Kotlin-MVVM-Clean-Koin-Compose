package gov.sa.scisp.di

import gov.sa.scisp.data.network.di.retrofitModule
import gov.sa.scisp.data.network.service.LoginApiService
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val servicesModule = module {
    includes(retrofitModule)

    single<LoginApiService> { get<Retrofit>().create(LoginApiService::class.java) }
}