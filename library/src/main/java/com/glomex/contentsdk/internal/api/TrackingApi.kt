package com.glomex.contentsdk.internal.api

import retrofit2.Call
import retrofit2.http.*

/** Tracking API. */
internal interface TrackingApi {

    @GET
    fun get(@Url url: String, @QueryMap body: Map<String, String>): Call<Void>

    @POST
    fun post(@Url url: String, @Body body: Map<String, String>): Call<Void>

}