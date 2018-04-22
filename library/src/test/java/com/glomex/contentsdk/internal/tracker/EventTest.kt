package com.glomex.contentsdk.internal.tracker

import com.glomex.contentsdk.data.Tracking
import com.glomex.contentsdk.data.TrackingTest
import com.glomex.contentsdk.internal.Session
import com.glomex.contentsdk.internal.event.Event
import org.junit.Assert.*
import org.junit.Test
import java.util.*

/** Test for [Event]. */
class EventTest {

    /**
     * Tests method is copied from [Tracking].
     */
    @Test
    fun build_copiesMethod() {
        val session = Session.generate()
        val tracking = TrackingTest.random()
        val event = Event.build(session, tracking)
        assertEquals(tracking.method, event.method)
    }

    /**
     * Tests url is copied from [Tracking].
     */
    @Test
    fun build_copiesUrl() {
        val session = Session.generate()
        val tracking = TrackingTest.random()
        val event = Event.build(session, tracking)
        assertEquals(tracking.url, event.url)
    }

    /**
     * Tests session ID is added to resulting params.
     */
    @Test
    fun build_sessionIdAddedToParams() {
        val session = Session.generate()
        val tracking = TrackingTest.random()
        val event = Event.build(session, tracking)
        assertTrue(event.params.containsKey(Event.PARAM_SESSION_ID))
        assertEquals(session.id, event.params.get(Event.PARAM_SESSION_ID))
    }

    /**
     * Tests client info is added to resulting params.
     */
    @Test
    fun build_clientInfoAddedToParams() {
        val session = Session.generate()
        val tracking = TrackingTest.random()
        val event = Event.build(session, tracking)
        assertTrue(event.params.containsKey(Event.PARAM_CLIENT_INFO))
        assertEquals(session.client, event.params[Event.PARAM_CLIENT_INFO])
    }

    /**
     * Tests payload is added to resulting params.
     */
    @Test
    fun build_payloadAddedToParams() {
        val session = Session.generate()
        val paramsCount = Random(System.currentTimeMillis()).nextInt(10)
        val payload = mutableMapOf<String, String>()
        (0..paramsCount).forEach {
            payload[UUID.randomUUID().toString()] = UUID.randomUUID().toString()
        }
        val tracking = TrackingTest.random(payload)
        val event = Event.build(session, tracking)
        payload.forEach({ key, value ->
            assertTrue(event.params.containsKey(key))
            assertEquals(value, event.params[key])
        })
    }

    /**
     * Tests custom params are added to resulting params.
     */
    @Test
    fun build_customParamsAddedToParams() {
        val session = Session.generate()
        val tracking = TrackingTest.random()
        val paramsCount = Random(System.currentTimeMillis()).nextInt(10)
        val customParams = mutableListOf<Pair<String, String>>()
        (0..paramsCount).forEach {
            val param = Pair(UUID.randomUUID().toString(), UUID.randomUUID().toString())
            customParams.add(param)
        }
        val event = Event.build(session, tracking, {
            customParams.forEach { (key, value) -> param(key, value) }
        })
        customParams.forEach({ (key, value) ->
            assertTrue(event.params.containsKey(key))
            assertEquals(value, event.params[key])
        })
    }


}