package com.glomex.contentsdk.sample.load

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.glomex.contentsdk.Content
import com.glomex.contentsdk.ContentSdk
import com.glomex.contentsdk.sample.R
import com.glomex.contentsdk.sample.track.ContentTrackingActivity
import com.glomex.contentsdk.sample.utils.TextWatcherUtils

/** [ContentLoadContract.View] implementation. */
class ContentLoadActivity : AppCompatActivity(), ContentLoadContract.View {

    private lateinit var integrationId: EditText
    private lateinit var contentId: EditText
    private lateinit var pageUrl: EditText
    private lateinit var errorMessage: TextView
    private lateinit var submit: View

    private lateinit var inputControls: Array<View>

    private val presenter: ContentLoadContract.Presenter = ContentLoadPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_load_activity)

        integrationId = findViewById(R.id.main_integration_id)
        contentId = findViewById(R.id.main_content_id)
        pageUrl = findViewById(R.id.main_page_url)
        errorMessage = findViewById(R.id.main_error)
        submit = findViewById(R.id.main_submit)

        inputControls = arrayOf(
                integrationId,
                contentId,
                pageUrl,
                errorMessage,
                submit
        )

        val inputWatcher = TextWatcherUtils.watchTextChanged {
            var isSubmitEnabled = true
            if (integrationId.text.isEmpty()) {
                isSubmitEnabled = false
            }
            if (contentId.text.isEmpty()) {
                isSubmitEnabled = false
            }
            if (pageUrl.text.isEmpty()) {
                isSubmitEnabled = false
            }
            submit.isEnabled = isSubmitEnabled
        }

        integrationId.addTextChangedListener(inputWatcher)
        contentId.addTextChangedListener(inputWatcher)
        pageUrl.addTextChangedListener(inputWatcher)
        submit.setOnClickListener {
            presenter.load(
                    integrationId.text.toString(),
                    contentId.text.toString(),
                    pageUrl.text.toString()
            )
        }

        presenter.setView(this)
    }

    override fun setInputControlsEnabled(enabled: Boolean) {
        inputControls.forEach { view -> view.isEnabled = enabled }
    }

    override fun showContent(config: ContentSdk.ContentConfig, content: Content) {
        startActivity(ContentTrackingActivity.createIntent(this, config))
    }

    override fun showError(message: String?) {
        if (TextUtils.isEmpty(message)) {
            errorMessage.visibility = View.GONE
        } else {
            errorMessage.text = message
            errorMessage.visibility = View.VISIBLE
        }
    }
}