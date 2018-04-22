package com.glomex.contentsdk.internal.tracker

import com.glomex.contentsdk.internal.event.Event

/** Used to track events. */
internal interface Tracker {

    fun track(event: Event,
              callback: (() -> Unit)? = null,
              error: ((Throwable) -> Unit)? = null)

}