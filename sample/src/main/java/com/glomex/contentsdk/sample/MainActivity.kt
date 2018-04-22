package com.glomex.contentsdk.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.glomex.contentsdk.Content
import com.glomex.contentsdk.ContentSdk

/** Main activity. */
class MainActivity : AppCompatActivity() {

    private lateinit var integrationId: EditText
    private lateinit var contentId: EditText
    private lateinit var pageUrl: EditText
    private lateinit var errorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        integrationId = findViewById(R.id.main_integration_id)
        contentId = findViewById(R.id.main_content_id)
        pageUrl = findViewById(R.id.main_page_url)
        errorMessage = findViewById(R.id.main_error)

        val submit : Button = findViewById(R.id.main_submit)

        val inputWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
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
        }

        integrationId.addTextChangedListener(inputWatcher)
        contentId.addTextChangedListener(inputWatcher)
        pageUrl.addTextChangedListener(inputWatcher)
        submit.setOnClickListener {
            errorMessage.visibility = GONE
            getContent(
                    integrationId.text.toString(),
                    contentId.text.toString(),
                    pageUrl.text.toString()
            )
        }
    }

    fun getContent(integrationId: String, contentId: String, pageUrl: String) {
        val config = ContentSdk.ContentConfig(
                integrationId = integrationId,
                contentId = contentId,
                pageUrl = pageUrl
        )
        ContentSdk.load(config, { content -> onContentLoaded(content) }, { error -> onError(error) })
    }

    fun onContentLoaded(content: Content) {
        val intent = Intent(this, ContentActivity::class.java)
        startActivity(intent)
    }

    fun onError(error: Throwable) {
        errorMessage.text = error.message
        errorMessage.visibility = VISIBLE
    }
}