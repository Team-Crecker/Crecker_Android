package org.techtown.crecker.home.data

import androidx.core.app.NotificationCompat
import com.google.gson.annotations.SerializedName
import org.techtown.crecker.news.data.NewsIdx

data class HomeBannerImgData(
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data : Data
) {data class Data(
    @SerializedName("homeBannerIdx")
    val homeBannerIdx : Int,
    @SerializedName("url")
    val url : String
)}