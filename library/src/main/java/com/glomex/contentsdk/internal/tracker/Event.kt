package com.glomex.contentsdk.internal.tracker

import com.glomex.contentsdk.data.Method
import com.glomex.contentsdk.data.Tracking
import com.glomex.contentsdk.internal.Session

/** Tracking event. */
internal data class Event constructor(
        val method: Method,
        val url: String,
        val params: Map<String, String>
) {
    private constructor(builder: Builder) : this(
            builder.method,
            builder.url,
            builder.params
    )

    class Builder(
            session: Session,
            tracking: Tracking
    ) {
        val method: Method = tracking.method
        val url: String = tracking.url
        @Suppress("JoinDeclarationAndAssignment")
        val params: MutableMap<String, String>

        init {
            params = mutableMapOf(
                    Pair(PARAM_SESSION_ID, session.id),
                    Pair(PARAM_CLIENT_INFO, session.client)
            )
            params.putAll(tracking.payload)
        }

        fun param(key: String, value: String): Builder {
            params[key] = value
            return this
        }

        fun build() = Event(this)
    }

    companion object {
        /**
         * Used to create [Event] as Builder pattern.
         */
        inline fun build(session: Session, tracking: Tracking, block: Builder.() -> Unit = {})
                = Builder(session, tracking).apply(block).build()

        // default parameters
        internal const val PARAM_SESSION_ID = "sessionId"
        internal const val PARAM_CLIENT_INFO = "clientInfo"
        // events name
        internal const val CONTENT_BEGIN = "contentBegin"
        internal const val AD_BEGIN = "adBegin"
        // events parameters
        internal const val PARAM_AD_ROLL_NAME = "adRollName"
    }

}