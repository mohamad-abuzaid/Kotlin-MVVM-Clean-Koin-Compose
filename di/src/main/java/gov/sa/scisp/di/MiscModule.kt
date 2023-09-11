package gov.sa.scisp.di

import gov.sa.scisp.data.storage.PreferencesStorage
import gov.sa.scisp.data.storage.TokenManager
import gov.sa.scisp.domain.main.token.ITokenManager
import gov.sa.scisp.domain.utils.storage.ILocalPreferencesStorage
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