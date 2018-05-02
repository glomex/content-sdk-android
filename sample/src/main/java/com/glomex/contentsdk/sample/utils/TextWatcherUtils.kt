package com.glomex.contentsdk.sample.utils

import android.text.Editable
import android.text.TextWatcher

/** [TextWatcher] wrapper. */
object TextWatcherUtils {

    fun watchTextChanged(callback: (s: CharSequence) -> Unit): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                callback.invoke(s)
            }

        }
    }

}