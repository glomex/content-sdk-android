package com.glomex.contentsdk.error

import android.support.annotation.Keep

/** Content SDK error. */
@Keep
open class ContentSdkError(
        /** Error code. */
        val code: Int,
        /** Error message. */
        message: String,
        /** Error cause. */
        cause: Throwable? = null
) : Error(message, cause) {
    /** Constants. */
    companion object {
        /** Generic error. Used when it is hard to determine source of problem. */
        @Keep
        const val GENERIC_ERROR = 1001
        /** Network error. Indicates problem with Internet connection. */
        @Keep
        const val NETWORK_ERROR = 1002
    }
}
