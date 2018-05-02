package com.glomex.contentsdk.internal

import com.glomex.contentsdk.Tracker
import com.glomex.contentsdk.data.AdType
import com.glomex.contentsdk.data.Tracking
import com.glomex.contentsdk.internal.tracker.Event
import com.glomex.contentsdk.internal.tracker.EventTracker

/** [Tracker] implementation. */
internal class TrackerImpl(
        private val session: Session,
        private val events: Map<String, List<Tracking>>,
        private val tracker: EventTracker
): Tracker {
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