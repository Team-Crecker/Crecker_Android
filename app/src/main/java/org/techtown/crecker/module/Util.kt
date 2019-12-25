package org.techtown.crecker.module

import android.util.Log

fun String.debugLog(tag: String = "Success"){
    Log.d(tag, this)
}