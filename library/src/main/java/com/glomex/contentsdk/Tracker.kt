package com.glomex.contentsdk

import android.support.annotation.Keep
import com.glomex.contentsdk.data.AdType

/** Used to track content events. */
@Keep
interface Tracker {
    /**
     * Used to track content begin event.
     */
    fun trackContentBegin()

    /**
     * Used to track Ad roll begin event.
     */
    fun trackAdBegin(adRollName: AdType)
}