package com.glomex.contentsdk.sample.track

import com.glomex.contentsdk.Content
import com.glomex.contentsdk.data.AdType

/** [ContentTrackingContract.Presenter] implementation. */
class ContentTrackingPresenter: ContentTrackingContract.Presenter {

    private lateinit var view: ContentTrackingContract.View
    private lateinit var content: Content

    override fun setView(view: ContentTrackingContract.View) {
        this@ContentTrackingPresenter.view = view
    }

    override fun setContent(content: Content) {
        this@ContentTrackingPresenter.content = content
    }

    override fun trackContentBegin() {
        content.trackContentBegin()
    }

    override fun trackAdBegin(adRollName: AdType) {
        content.trackAdBegin(adRollName)
    }
}