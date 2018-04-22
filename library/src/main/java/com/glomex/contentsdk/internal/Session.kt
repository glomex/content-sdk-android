package com.glomex.contentsdk.internal

import android.os.Build
import com.glomex.contentsdk.BuildConfig
import java.util.UUID

/** Session. */
internal class Session private constructor(val id: String, val client: String) {

    companion object {
        /**
         * Used to generate session info.
         */
        fun generate() = Session(
                UUID.randomUUID().toString(),
                "Android ${Build.VERSION.SDK_INT}, ${Build.MODEL}, ${BuildConfig.VERSION_NAME}"
        )
    }
}