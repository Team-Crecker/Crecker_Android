package org.techtown.crecker.ads.event

import android.content.Intent

data class CtgResultEvent(
    val requestCode: Int,
    val resultCode: Int,
    val data: Intent?
)

