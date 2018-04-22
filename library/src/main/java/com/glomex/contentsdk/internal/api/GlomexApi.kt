package com.glomex.contentsdk.internal.api

import com.glomex.contentsdk.data.Video
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/** REST API. */
internal interface GlomexApi {

    @GET("video")
    fun loadVideo(@Query("integration_id") integrationId: String,
                  @Query("content_id") contentId: String,
                  @Query(value = "page_url", encoded = true) pageUrl: String): Call<VideoResponse>

    data class VideoResponse(
            @SerializedName("video") val video: Video
    )

    companion object {
        val BASE_URL = "https://integration-sdk-eu-west-1.dev.mes.glomex.cloud/"
    }

}