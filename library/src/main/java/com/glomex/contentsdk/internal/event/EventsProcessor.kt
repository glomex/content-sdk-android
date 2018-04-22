package com.glomex.contentsdk.internal.event

import com.glomex.contentsdk.data.AdType

/** Used to process events. */
interface EventsProcessor {
    /**
     * Used to track content begin event.
     */
    fun trackContentBegin()

    /**
     * Used to track Ad roll begin event.
     */
    fun trackAdBegin(adRollName: AdType)
}