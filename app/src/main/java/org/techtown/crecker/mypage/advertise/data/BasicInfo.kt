package org.techtown.crecker.mypage.advertise.data
import com.google.gson.annotations.SerializedName


data class BasicInfo(
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
        @SerializedName("1")
        var x1: Int,
        @SerializedName("2")
        var x2: Int,
        @SerializedName("3")
        var x3: Int,
        @SerializedName("4")
        var x4: Int
    )
}