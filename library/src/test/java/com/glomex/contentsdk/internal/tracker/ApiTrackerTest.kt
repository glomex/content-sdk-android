package com.glomex.contentsdk.internal.tracker

import com.glomex.contentsdk.data.Method
import com.glomex.contentsdk.data.Tracking
import com.glomex.contentsdk.internal.Session
import com.glomex.contentsdk.internal.api.TrackingApi
import com.glomex.contentsdk.internal.event.Event
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import java.util.*

/** Tests for [ApiTracker]. */
class ApiTrackerTest {

    private val apiMock = mock<TrackingApi> {
        on { get(any(), any()) } doReturn mock<Call<Void>>()
        on { post(any(), any()) } doReturn mock<Call<Void>>()
    }

    private lateinit var target: Tracker

    @Before
    fun setUp() {
        target = ApiTracker(apiMock)
    }

    /**
     * Tests tracker tracks GET requests.
     */
    @Test
    fun track_getEventCallsApi() {
        val session = Session.generate()
        val tracking = Tracking(
                method = Method.GET,
                url = UUID.randomUUID().toString(),
                payload = mapOf()
        )
        val event = Event.build(session, tracking)
        target.track(event)
        verify(apiMock).get(event.url, event.params)
    }

    /**
     * Tests tracker tracks POST requests.
     */
    @Test
    fun track_postEventCallsApi() {
        val session = Session.generate()
        val tracking = Tracking(
                method = Method.POST,
                url = UUID.randomUUID().toString(),
                payload = mapOf()
        )
        val event = Event.build(session, tracking)
        target.track(event)
        verify(apiMock).post(event.url, event.params)
    }

}