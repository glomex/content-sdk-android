package com.glomex.contentsdk

import java.util.*

/** Test utilities. */
object Utils {

    /**
     * Generates list of random objects.
     * @param capacity number of objects to be generated. By default random number in range [0, 10)
     * @param factory object factory method. Used to generate object.
     * @return list of random objects.
     */
    fun <T> randomList(capacity: Int = Random(System.currentTimeMillis()).nextInt(10), factory: () -> T): List<T> {
        val result = mutableListOf<T>()
        (0..capacity).forEach { result.add(factory()) }
        return result
    }

}