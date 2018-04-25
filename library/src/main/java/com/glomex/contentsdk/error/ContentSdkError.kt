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
) : Error(message, cause)
