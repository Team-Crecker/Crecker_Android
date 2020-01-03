package org.techtown.crecker.mypage.advertise.data
import com.google.gson.annotations.SerializedName


data class VideoInfo(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("statusCode")
    var statusCode: Int,
    @SerializedName("success")
    var success: Boolean
) {
    data class Data(
        @SerializedName("publishedAt")
        var publishedAt: String,
        @SerializedName("thumbnails")
        var thumbnails: String
    )
}