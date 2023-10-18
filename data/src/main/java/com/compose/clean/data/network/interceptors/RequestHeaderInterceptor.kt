package com.compose.clean.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class RequestHeaderInterceptor: Interceptor {
  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()

    val maxAge = 60 * 30
    val newRequest = request.newBuilder()
      .addHeader("Cache-Control", "public, max-age=$maxAge")
      .build()

    return chain.proceed(newRequest)
  }
}