package com.compose.clean.di

import com.compose.clean.data.network.di.retrofitModule
import com.compose.clean.data.network.service.authentication.LanguageApiService
import com.compose.clean.data.network.service.authentication.LoginApiService
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