package gov.sa.scisp.di

import gov.sa.scisp.data.database.AppDatabase
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val databaseModule = module {
    single { AppDatabase.getInstance(context = get()) }

    single { get<AppDatabase>().placeholderDAO() }
}