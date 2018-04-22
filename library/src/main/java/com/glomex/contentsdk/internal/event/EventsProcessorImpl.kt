package com.glomex.contentsdk.internal.event

import com.glomex.contentsdk.data.AdType
import com.glomex.contentsdk.data.Tracking
import com.glomex.contentsdk.internal.Session
import com.glomex.contentsdk.internal.tracker.Tracker

/** Events processor. */
internal class EventsProcessorImpl(
        private val session: Session,
        private val events: Map<String, List<Tracking>>,
        private val tracker: Tracker
): EventsProcessor {
    override fun trackContentBegin() {
        events[Event.CONTENT_BEGIN]?.forEach {
            tracker.track(Event.build(session, it))
        }
    }

    override fun trackAdBegin(adRollName: AdType) {
        events[Event.AD_BEGIN]?.forEach {
            tracker.track(Event.build(session, it, {
                param(Event.PARAM_AD_ROLL_NAME, adRollName.value)
            }))
        }
    }
}