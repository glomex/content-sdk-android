package com.glomex.contentsdk.data

import com.google.gson.annotations.SerializedName

/** Error. */
internal data class Error(
        @SerializedName("error") val message: String
)