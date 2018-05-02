package com.glomex.contentsdk.sample.load

import com.glomex.contentsdk.ContentSdk

/** [ContentLoadContract.Presenter] implementation. */
class ContentLoadPresenter: ContentLoadContract.Presenter {
    private lateinit var view: ContentLoadContract.View

    override fun setView(view: ContentLoadContract.View) {
        this@ContentLoadPresenter.view = view
    }

    override fun load(integrationId: String, contentId: String, pageUrl: String) {
        view.setInputControlsEnabled(false)
        view.showError(null)

        val config = ContentSdk.ContentConfig(
                integrationId = integrationId,
                contentId = contentId,
                pageUrl = pageUrl
        )
        ContentSdk.load(
                config,
                {
                    content -> view.showContent(config, content)
                    view.setInputControlsEnabled(true)
                },
                {
                    error -> view.showError(error.cause?.message ?: error.message)
                    view.setInputControlsEnabled(true)
                }
        )
    }
}