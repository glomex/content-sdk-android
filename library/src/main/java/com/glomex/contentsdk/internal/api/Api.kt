package com.glomex.contentsdk.internal.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** HTTP client provider. */
internal object Api {
    /** Glomex Rest API client. */
    val glomex: GlomexApi by lazy {
        Retrofit.Builder()
                .baseUrl(GlomexApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClientProvider.getHttpClient())
                .build()
                .create(GlomexApi::class.java)
    }
    /** Tracking HTTP client. */
    val tracking: TrackingApi by lazy {
        Retrofit.Builder()
                // need to set anything to init Retrofit, won't be used though
                .baseUrl("https://glomex.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClientProvider.getHttpClient())
                .build()
                .create(TrackingApi::class.java)
    }
}