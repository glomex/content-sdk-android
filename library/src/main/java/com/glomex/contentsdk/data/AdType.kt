package com.glomex.contentsdk.data

import android.support.annotation.Keep

/** Ad type. */
@Keep
enum class AdType(
        /** Text value. */
        val value: String
) {
    /** Pre-roll. */
    PREROLL("preroll"),
    /** Mid-roll. */
    MIDROLL("midroll"),
    /** Post-roll. */
    POSTROLL("postroll"),
}