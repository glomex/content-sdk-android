package com.glomex.contentsdk.error

import android.support.annotation.Keep

/** Content loading error. */
@Keep
class ContentLoadingError(code: Int, message: String, cause: Throwable? = null)
    : ContentSdkError(code, message, cause) {

    /** Constants. */
    companion object {
        /** Content can't be parsed. */
        @Keep
        const val PARSING_ERROR = 2001
        /** Response error. When server returns error codes. */
        @Keep
        const val RESPONSE_ERROR = 2002
    }
}