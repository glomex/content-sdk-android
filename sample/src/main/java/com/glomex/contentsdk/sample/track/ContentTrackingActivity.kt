package com.glomex.contentsdk.sample.track

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.glomex.contentsdk.Content
import com.glomex.contentsdk.ContentSdk
import com.glomex.contentsdk.data.AdType
import com.glomex.contentsdk.sample.R

/** [ContentTrackingContract.View] implementation. */
class ContentTrackingActivity : AppCompatActivity(), ContentTrackingContract.View {

    private lateinit var progressiveSource: TextView
    private lateinit var progressiveHls: TextView

    private val presenter: ContentTrackingContract.Presenter = ContentTrackingPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_tracking_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        progressiveSource = findViewById(R.id.track_sources_progressive)
        progressiveHls = findViewById(R.id.track_sources_hls)
        findViewById<View>(R.id.track_contentbegin).setOnClickListener {
            presenter.trackContentBegin()
        }
        val adTypeSpinner = findViewById<Spinner>(R.id.track_adbegin_type)
        adTypeSpinner.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                AdType.values()
        )
        findViewById<View>(R.id.track_adbegin).setOnClickListener {
            val type = adTypeSpinner.selectedItem as AdType
            presenter.trackAdBegin(type)
        }

        presenter.setView(this)
        getContent()?.let {
            presenter.setContent(it)
        } ?: finish()
    }

    override fun showSources(progressive: String?, hls: String?) {
        progressiveSource.text = getString(R.string.track_progressive_format, progressive)
        progressiveHls.text = getString(R.string.track_hls_format, hls)
    }

    private fun getContent(): Content? {
        return intent.extras?.getParcelable<ContentSdk.ContentConfig>(EXTRA_CONTENT_CONFIG)?.let {
            ContentSdk.get(it)
        }
    }

    companion object {
        private const val EXTRA_CONTENT_CONFIG = "extra:content_config"

        fun createIntent(context: Context, config: ContentSdk.ContentConfig): Intent {
            val intent = Intent(context, ContentTrackingActivity::class.java)
            intent.putExtra(EXTRA_CONTENT_CONFIG, config)
            return intent
        }

    }
}