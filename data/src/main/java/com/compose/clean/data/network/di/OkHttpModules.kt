package com.compose.clean.data.network.di

import com.compose.clean.data.network.factory.OkHttpFactory
import com.compose.clean.data.network.interceptors.RequestHeaderInterceptor
import com.compose.clean.data.network.interceptors.JWTAuthenticator
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