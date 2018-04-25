package com.glomex.contentsdk.error

import android.support.annotation.Keep

/** Generic Content SDK error. */
@Keep
class ContentSdkGenericError(code: Int, message: String, cause: Throwable? = null)
    : ContentSdkError(DOMAIN, code, message, cause) {

    /** Constants. */
    companion object {
        private const val DOMAIN = 1000
        /** Generic error. Used when it is hard to determine source of problem. */
        @Keep
        const val GENERIC_ERROR = 1001
        /** Network error. Indicates problem with Internet connection. */
        @Keep
        const val NETWORK_ERROR = 1002
    }
}