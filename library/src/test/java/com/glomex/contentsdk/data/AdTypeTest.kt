package com.glomex.contentsdk.data

import java.util.*

/** Used to generate random [AdType]. */
object AdTypeTest {
    fun random(): AdType {
        val values = AdType.values()
        return values[Random(System.currentTimeMillis()).nextInt(values.size)]
    }
}