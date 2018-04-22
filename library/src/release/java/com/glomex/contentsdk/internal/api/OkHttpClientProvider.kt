package com.glomex.contentsdk.internal.api

import okhttp3.OkHttpClient

/** [OkHttpClient] provider, */
internal object OkHttpClientProvider {

    fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

}