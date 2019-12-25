package org.techtown.crecker.ads.category

import android.content.Intent

data class CtgResultEvent(
    val requestCode: Int,
    val resultCode: Int,
    val data: Intent?
)

