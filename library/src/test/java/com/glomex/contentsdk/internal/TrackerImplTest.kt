package com.glomex.contentsdk.internal

import com.glomex.contentsdk.Utils
import com.glomex.contentsdk.data.AdTypeTest
import com.glomex.contentsdk.data.Tracking
import com.glomex.contentsdk.data.TrackingTest
import com.glomex.contentsdk.internal.tracker.Event
import com.glomex.contentsdk.internal.tracker.EventTracker
import com.nhaarman.mockito_kotlin.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/** Tests for [TrackerImpl]. */
class TrackerImplTest {
    private val session = Session.generate()
    private val events = mapOf(
            Pair(Event.CONTENT_BEGIN, Utils.randomList(factory = TrackingTest::random)),
            Pair(Event.AD_BEGIN, Utils.randomList(factory = TrackingTest::random))
    )
    private val trackerMock = mock<EventTracker>()

    private lateinit var target: com.glomex.contentsdk.Tracker

    @Before
    fun setUp() {
        target = TrackerImpl(
                session = session,
                events = events,
                tracker = trackerMock
        )
    }

    @Test
    fun trackContentBegin_tracksEventsForCorrectType() {
        val captor = argumentCaptor<Event>()
        val trackings = events[Event.CONTENT_BEGIN]!!
        target.trackContentBegin()
        verify(trackerMock, times(trackings.size)).track(captor.capture(), anyOrNull(), anyOrNull())
        val captures = captor.allValues
        (0..(trackings.size - 1)).forEach { i -> verifyEvent(captures[i], trackings[i]) }
    }

    @Test
    fun trackAdBegin_tracksEventsForCorrectType() {
        val captor = argumentCaptor<Event>()
        val trackings = events[Event.AD_BEGIN]!!
        val adType = AdTypeTest.random()
        target.trackAdBegin(adType)
        verify(trackerMock, times(trackings.size)).track(captor.capture(), anyOrNull(), anyOrNull())
        val captures = captor.allValues
        (0..(trackings.size - 1)).forEach { i -> verifyEvent(captures[i], trackings[i]) }
    }

    private fun verifyEvent(event: Event, tracking: Tracking, args: Map<String, String> = mapOf()) {
        // check API structure
        assertEquals(tracking.method, event.method)
        assertEquals(tracking.url, tracking.url)
        // check params
        assertEquals(session.id, event.params[Event.PARAM_SESSION_ID])
        assertEquals(session.client, event.params[Event.PARAM_CLIENT_INFO])
        tracking.payload.forEach({ key, value ->
            assertTrue(event.params.containsKey(key))
            assertEquals(value, event.params[key])
        })
        // check arguments
        args.forEach({ key, value ->
            assertTrue(event.params.containsKey(key))
            assertEquals(value, event.params[key])
        })
    }
}