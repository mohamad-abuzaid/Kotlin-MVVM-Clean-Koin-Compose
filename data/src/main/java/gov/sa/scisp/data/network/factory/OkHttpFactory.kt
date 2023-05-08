package gov.sa.scisp.data.network.factory

import gov.sa.scisp.data.network.interceptors.RequestHeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class OkHttpFactory {

    companion object {

        fun getInstance(requestHeaderInterceptor: RequestHeaderInterceptor): OkHttpClient {
            synchronized(this) {
                val okHttpClientBuilder = okhttp3.OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(1, TimeUnit.HOURS)
                    .addNetworkInterceptor(requestHeaderInterceptor)
                    .addInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                    )

                return okHttpClientBuilder.build()
            }
        }
    }
}