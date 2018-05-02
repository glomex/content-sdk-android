package com.glomex.contentsdk.sample.load

import com.glomex.contentsdk.Content
import com.glomex.contentsdk.ContentSdk

/** Content contract.  */
interface ContentLoadContract {

    interface View {
        fun setInputControlsEnabled(enabled: Boolean)

        fun showContent(config: ContentSdk.ContentConfig, content: Content)

        fun showError(message: String?)
    }

    interface Presenter {

        fun setView(view: View)

        fun load(integrationId: String,
                 contentId: String,
                 pageUrl: String)
    }

}