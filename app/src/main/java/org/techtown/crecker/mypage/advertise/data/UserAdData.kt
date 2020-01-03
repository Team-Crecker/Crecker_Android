package org.techtown.crecker.mypage.advertise.data
import com.google.gson.annotations.SerializedName


data class UserAdData(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("message")
    var message: String,
    @SerializedName("statusCode")
    var statusCode: Int,
    @SerializedName("success")
    var success: Boolean
) {
    data class Data(
        @SerializedName("adIdx")
        var adIdx: Int,
        @SerializedName("cash")
        var cash: String,
        @SerializedName("createAt")
        var createAt: Int,
        @SerializedName("thumbnail")
        var thumbnail: String,
        @SerializedName("title")
        var title: String,
        @SerializedName("uploadTo")
        var uploadTo: Int,
        @SerializedName("userAdIdx")
        var userAdIdx: Int
    )
}