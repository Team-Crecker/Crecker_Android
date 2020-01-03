package org.techtown.crecker.home.data

import androidx.core.app.NotificationCompat
import com.google.gson.annotations.SerializedName

data class HomeBannerImgData(
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data : String,
    @SerializedName("homeBannerIdx")
    val homeBannerIdx : Int
)