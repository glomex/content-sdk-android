package com.glomex.contentsdk.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

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
@SuppressWarnings("ParcelCreator")
@Parcelize
internal data class Tracking(
        @SerializedName("method") val method: Method,
        @SerializedName("url") val url: String,
        @SerializedName("payload") val payload: Map<String, String> = mapOf()
): Parcelable


