package com.glomex.contentsdk.error

import android.support.annotation.Keep

/** Content SDK error. */
@Keep
abstract class ContentSdkError(
        /** Error domain. */
        @Suppress("unused") private val domain: Int,
        /** Error code. */
        val code: Int,
        /** Error message. */
        message: String,
        /** Error cause. */
        cause: Throwable? = null
) : Error(message, cause) {

    /** Generic Content SDK error. */
    @Keep
    class ContentSdkGenericError(code: Int, message: String, cause: Throwable? = null)
        : ContentSdkError(DOMAIN, code, message, cause) {

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

    /** Content loading error. */
    @Keep
    class ContentLoadingError(code: Int, message: String, cause: Throwable? = null)
        : ContentSdkError(DOMAIN, code, message, cause) {

        companion object {
            private const val DOMAIN = 2000
            /** Content can't be parsed. */
            @Keep
            const val PARSING_ERROR = 2001
            /** Response error. When server returns error codes. */
            @Keep
            const val RESPONSE_ERROR = 2002
        }
    }

    /** Tracking error. */
    @Keep
    class TrackingError(code: Int, message: String, cause: Throwable? = null)
        : ContentSdkError(DOMAIN, code, message, cause) {

        companion object {
            private const val DOMAIN = 3000
            /** Response error. When server returns error codes. */
            @Keep
            const val RESPONSE_ERROR = 3001
        }
    }

}