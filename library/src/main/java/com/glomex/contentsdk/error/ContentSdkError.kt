package com.glomex.contentsdk.error

import android.support.annotation.Keep

/** Content SDK error. */
@Keep
abstract class ContentSdkError(
        @Suppress("unused") private val domain: Int,
        val code: Int,
        message: String,
        cause: Throwable? = null
) : Error(message, cause) {

    @Keep
    class ContentSdkGenericError(code: Int, message: String, cause: Throwable? = null)
        : ContentSdkError(DOMAIN, code, message, cause) {

        companion object {
            private const val DOMAIN = 1000
            @Keep
            const val GENERIC_ERROR = 1001
            @Keep
            const val NETWORK_ERROR = 1002
        }
    }

    @Keep
    class ContentLoadingError(code: Int, message: String, cause: Throwable? = null)
        : ContentSdkError(DOMAIN, code, message, cause) {

        companion object {
            private const val DOMAIN = 2000
            @Keep
            const val PARSING_ERROR = 2001
            @Keep
            const val RESPONSE_ERROR = 2002
        }
    }

    @Keep
    class TrackingError(code: Int, message: String, cause: Throwable? = null)
        : ContentSdkError(DOMAIN, code, message, cause) {

        companion object {
            private const val DOMAIN = 3000
            @Keep
            const val RESPONSE_ERROR = 3001
        }
    }

}