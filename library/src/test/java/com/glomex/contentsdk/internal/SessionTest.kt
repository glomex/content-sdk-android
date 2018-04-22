package com.glomex.contentsdk.internal

import android.os.Build
import com.glomex.contentsdk.BuildConfig
import org.junit.Assert.assertTrue
import org.junit.Test

/** Test for [Session]. */
class SessionTest {

    @Test
    fun generate_idFormat() {
        assertTrue(ID_MATCHER.matches(Session.generate().id))
    }

    @Test
    fun generate_clientFormat() {
        assertTrue(CLIENT_MATCHER.matches(Session.generate().client))
    }

    companion object {
        val ID_MATCHER = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}".toRegex()
        val CLIENT_MATCHER = "Android ${Build.VERSION.SDK_INT}, ${Build.MODEL}, ${BuildConfig.VERSION_NAME}".toRegex()
    }

}