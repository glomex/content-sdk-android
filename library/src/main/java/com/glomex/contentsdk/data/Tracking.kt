package com.glomex.contentsdk.data

import com.google.gson.annotations.SerializedName

/**
 * Content record.
 * ```
 *  {
 *      method: "post",
 *      url: "https://player-feedback-mds.glomex.com/pf/",
 *      payload: {
 *          content_id: "v-123"
 *      }
 *  }
 * ```
 */
internal data class Tracking(
        @SerializedName("method") val method: Method,
        @SerializedName("url") val url: String,
        @SerializedName("payload") val payload: Map<String, String> = mapOf()
)


