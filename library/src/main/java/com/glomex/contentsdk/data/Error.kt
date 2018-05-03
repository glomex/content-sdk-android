package com.glomex.contentsdk.data

import com.google.gson.annotations.SerializedName
import java.lang.IllegalStateException

/** Error. */
internal data class Error(
        @SerializedName("error_code") val code: String?,
        @SerializedName("error") val error: String?
) {
    fun getMessage(): String = when {
        error != null -> error
        code != null -> code
        else -> throw IllegalStateException("Fail to parse error")
    }
}