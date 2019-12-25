package org.techtown.crecker.ads.category

import android.os.Handler
import com.squareup.otto.Bus
import android.os.Looper

object EventBus : Bus() {
    private val handler = Handler(Looper.getMainLooper())

    override fun post(event: Any) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event)
        } else {
            handler.post(Runnable { super@EventBus.post(event) })
        }
    }

    var isCtgSelected = false
}