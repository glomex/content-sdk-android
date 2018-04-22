package com.glomex.contentsdk

import android.support.annotation.Keep
import com.glomex.contentsdk.data.Source
import com.glomex.contentsdk.internal.event.EventsProcessor

/** Content interface. Used to get sources and track events. */
@Keep
interface Content: EventsProcessor {
    /**
     * Provides content sources (such as progressive or HLS).
     * @return content sources
     */
    fun getSources(): Source
}

