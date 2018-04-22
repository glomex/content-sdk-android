package com.glomex.contentsdk.data

import android.support.annotation.Keep

/** Ad type. */
@Keep
enum class AdType(val value: String) {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
}