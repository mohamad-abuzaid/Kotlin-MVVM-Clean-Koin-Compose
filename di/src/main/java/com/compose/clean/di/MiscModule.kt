package com.compose.clean.di

import com.compose.clean.data.storage.PreferencesStorage
import com.compose.clean.data.storage.TokenManager
import com.compose.clean.domain.main.token.ITokenManager
import com.compose.clean.domain.utils.storage.ILocalPreferencesStorage
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val miscModule = module {
    single(named("ioDispatcher")) { Dispatchers.IO }
    single(named("defaultDispatcher")) { Dispatchers.Default }

    single<ILocalPreferencesStorage> { PreferencesStorage(context = get()) }
    single<ITokenManager> { TokenManager(prefs = get()) }
}