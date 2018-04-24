package com.glomex.contentsdk

import android.support.annotation.Keep
import com.glomex.contentsdk.internal.ContentImpl
import com.glomex.contentsdk.internal.Session
import com.glomex.contentsdk.internal.api.Api
import com.glomex.contentsdk.internal.event.EventsProcessorImpl
import com.glomex.contentsdk.internal.loader.ApiContentLoader
import com.glomex.contentsdk.internal.loader.ContentLoader
import com.glomex.contentsdk.internal.tracker.ApiTracker
import com.glomex.contentsdk.internal.tracker.Tracker

/** Content SDK entry point. Used to load content. */
@Keep
object ContentSdk {
    /** Used to load content. */
    private val loader : ContentLoader by lazy { ApiContentLoader(Api.glomex) }
    /** Used to track events. */
    private val tracker : Tracker by lazy { ApiTracker(Api.tracking) }

    /**
     * Loads content.
     * @param config used to fetch content.
     * @param callback notifies when content is loaded successfully.
     * @param error notifies about any error occurred while loading content.
     */
    fun load(config: ContentConfig,
             callback: (content: Content) -> Unit,
             error: ((Throwable) -> Unit)? = null) {
        loader.load(config, { video ->
            val session = Session.generate()
            val processor = EventsProcessorImpl(session, video.tracking, tracker)
            val content = ContentImpl(video.source, processor)
            callback(content)
        }, error)
    }

    /**
     * Content configuration. Used to fetch content.
     */
    @Keep
    data class ContentConfig(
            /** Integration ID (e.g. teaser-1mcujg5frj4oa0fv2). */
            val integrationId: String,
            /** Content ID (e.g. v-bkjbsi6sv3m9). */
            val contentId: String,
            /** Page URL (e.g. http://www.tz.de). */
            val pageUrl: String
    )

}