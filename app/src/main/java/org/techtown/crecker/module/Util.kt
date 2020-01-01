package org.techtown.crecker.module

import android.util.Log
import java.text.DecimalFormat

fun String.debugLog(tag: String = "Success"){
    Log.d(tag, this)
}

fun String.putLog(tag: String = "debugResult"){
    Log.d(tag, this)
}

fun Int.formatMoney () : String{
    val formatter : DecimalFormat = DecimalFormat("###,###")
    val changeText = formatter.format(this)

    return changeText

}