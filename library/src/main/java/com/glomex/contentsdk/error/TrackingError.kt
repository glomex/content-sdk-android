package com.glomex.contentsdk.error

import android.support.annotation.Keep

/** Tracking error. */
@Keep
class TrackingError(code: Int, message: String, cause: Throwable? = null)
    : ContentSdkError(DOMAIN, code, message, cause) {

    /** Constants. */
    companion object {
        private const val DOMAIN = 3000
        /** Response error. When server returns error codes. */
        @Keep
        const val RESPONSE_ERROR = 3001
    }
}