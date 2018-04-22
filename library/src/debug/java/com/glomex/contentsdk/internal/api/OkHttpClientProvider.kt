package com.glomex.contentsdk.internal.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/** [OkHttpClient] provider, */
internal object OkHttpClientProvider {

    fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
    }

}