package com.glomex.contentsdk.error

import android.support.annotation.Keep

/** Tracking error. */
@Keep
class TrackingError(code: Int, message: String, cause: Throwable? = null)
    : ContentSdkError(code, message, cause) {

    /** Constants. */
    companion object {
        /** Response error. When server returns error codes. */
        @Keep
        const val RESPONSE_ERROR = 3001
    }
}