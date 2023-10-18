package com.compose.clean.data.network.factory

import com.google.gson.Gson
import com.compose.clean.data.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class RetrofitFactory {

    companion object {
        fun getInstance(baseUrl:String, okHttpClient: OkHttpClient, gsonParser: Gson): Retrofit {
            synchronized(this) {
                return Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gsonParser))
                    .build()
            }
        }
    }
}