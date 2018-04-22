package com.glomex.contentsdk.data

import java.util.*

/** Used to generate random [Method]. */
internal object MethodTest {
    fun random(): Method {
        val values = Method.values()
        return values[Random(System.currentTimeMillis()).nextInt(values.size)]
    }
}