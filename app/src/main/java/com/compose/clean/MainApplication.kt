package com.compose.clean

import android.app.Application
import com.compose.clean.di.databaseModule
import com.compose.clean.di.miscModule
import com.compose.clean.di.repositoriesModule
import com.compose.clean.di.servicesModule
import com.compose.clean.di.useCasesModule
import com.compose.clean.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class MainApplication : Application() {

    override fun onCreate() {
        Timber.d("onCreate()")
        super.onCreate()

        startKoin {

            // Log Koin into Android logger
            androidLogger()

            // Reference Android context
            androidContext(this@MainApplication)

            // Declare modules
            modules(
                listOf(
                    miscModule,
                    databaseModule,
                    viewModelsModule,
                    useCasesModule,
                    repositoriesModule,
                    servicesModule
                )
            )
        }

        if (BuildConfig.DEBUG) {

            // Log Timber into Android logger - only if debug mode
            Timber.plant(Timber.DebugTree())
        }
    }
}