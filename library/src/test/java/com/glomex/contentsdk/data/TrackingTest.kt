package com.glomex.contentsdk.data

import java.util.*

/** Used to generate [Tracking] for tests. */
internal object TrackingTest {
    fun random(): Tracking {
        return random(mapOf())
    }

    fun random(payload: Map<String, String> = mapOf()): Tracking {
        return Tracking(
                method = MethodTest.random(),
                url = UUID.randomUUID().toString(),
                payload = payload
        )
    }
}