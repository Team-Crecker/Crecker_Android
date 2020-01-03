package org.techtown.crecker.home.data

import android.accessibilityservice.GestureDescription
import com.google.gson.annotations.SerializedName
import org.techtown.crecker.membership.data.LoginResultData

data class HomeAdsListData (
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("thumbnail")
        val thumbnail : String,
        @SerializedName("title")
        val title : String,
        @SerializedName("cash")
        val cash : String,
        @SerializedName("adIdx")
        val adIdx : Int

    )
}