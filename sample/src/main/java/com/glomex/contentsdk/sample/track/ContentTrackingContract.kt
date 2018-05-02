package com.glomex.contentsdk.sample.track

import com.glomex.contentsdk.Content
import com.glomex.contentsdk.data.AdType

/** Content contract.  */
interface ContentTrackingContract {

    interface View

    interface Presenter {

        fun setView(view: View)

        fun setContent(content: Content)

        fun trackContentBegin()

        fun trackAdBegin(adRollName: AdType)
    }

}