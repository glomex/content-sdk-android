package com.glomex.contentsdk.data

import com.google.gson.annotations.SerializedName

/** HTTP method. */
internal enum class Method {
    @SerializedName("get") GET,
    @SerializedName("post") POST,
}