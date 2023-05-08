package gov.sa.scisp.data.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import gov.sa.scisp.data.BuildConfig
import gov.sa.scisp.data.network.factory.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
val retrofitModule = module {
    includes(okhttpModule)

    single(named("dataBaseUrl")) { BuildConfig.BASE_URL }
    single<Gson> { GsonBuilder().setPrettyPrinting().create() }

    single {
        RetrofitFactory.getInstance(
            baseUrl = get(named("dataBaseUrl")),
            okHttpClient = get(),
            gsonParser = get()
        )
    }
}