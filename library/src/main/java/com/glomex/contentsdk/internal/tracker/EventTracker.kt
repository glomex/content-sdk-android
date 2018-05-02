package com.glomex.contentsdk.internal.tracker

/** Used to track events. */
internal interface EventTracker {

    fun track(event: Event,
              callback: (() -> Unit)? = null,
              error: ((Throwable) -> Unit)? = null)

}