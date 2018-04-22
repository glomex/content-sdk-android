package com.glomex.contentsdk.internal

import com.glomex.contentsdk.Content
import com.glomex.contentsdk.data.AdType
import com.glomex.contentsdk.data.Source
import com.glomex.contentsdk.internal.event.EventsProcessor

/** Content implementation. */
internal class ContentImpl(
        private val source: Source,
        private val processor: EventsProcessor
): Content {

    override fun getSources(): Source = source

    override fun trackContentBegin() {
        processor.trackContentBegin()
    }

    override fun trackAdBegin(adRollName: AdType) {
        processor.trackAdBegin(adRollName)
    }

}