package com.glomex.contentsdk.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glomex.contentsdk.sample.load.ContentLoadActivity

/** Splash activity. */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, ContentLoadActivity::class.java))
        finish()
    }
}