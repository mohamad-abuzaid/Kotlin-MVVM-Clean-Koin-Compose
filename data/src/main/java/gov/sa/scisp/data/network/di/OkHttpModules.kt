package gov.sa.scisp.data.network.di

import gov.sa.scisp.data.network.factory.OkHttpFactory
import gov.sa.scisp.data.network.interceptors.RequestHeaderInterceptor
import gov.sa.scisp.data.network.interceptors.JWTAuthenticator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val okhttpModule = module {
    singleOf(::RequestHeaderInterceptor)
    singleOf(::JWTAuthenticator)

    single { OkHttpFactory.getInstance(requestHeaderInterceptor = get(), jwtAuthenticator = get()) }
}