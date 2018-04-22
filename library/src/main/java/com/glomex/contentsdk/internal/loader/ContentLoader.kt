package com.glomex.contentsdk.internal.loader

import com.glomex.contentsdk.ContentSdk
import com.glomex.contentsdk.data.Video

/** Used to load content. */
internal interface ContentLoader {

    fun load(config: ContentSdk.ContentConfig,
             callback: (video: Video) -> Unit,
             error: ((Throwable) -> Unit)? = null)

}