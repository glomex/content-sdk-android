package com.glomex.contentsdk.internal.tracker

import com.glomex.contentsdk.data.Method
import com.glomex.contentsdk.error.TrackingError
import com.glomex.contentsdk.internal.api.TrackingApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** Used to send tracking events to tracking endpoints by HTTP request. */
internal class ApiEventTracker(
        private val api: TrackingApi
): EventTracker {

    override fun track(event: Event,
                       callback: (() -> Unit)?,
                       error: ((Throwable) -> Unit)?) {
        val apiCallback = object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                error(t)
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    callback?.invoke()
                } else {
                    error?.invoke(TrackingError(
                            TrackingError.RESPONSE_ERROR,
                            "Tracking request failed",
                            RuntimeException(response.errorBody()?.string())
                    ))
                }
            }
        }
        when (event.method) {
            Method.GET -> api.get(event.url, event.params).enqueue(apiCallback)
            Method.POST -> api.post(event.url, event.params).enqueue(apiCallback)
        }
    }

}