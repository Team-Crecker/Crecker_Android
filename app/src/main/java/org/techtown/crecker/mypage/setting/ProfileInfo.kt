package org.techtown.crecker.mypage.setting
import com.google.gson.annotations.SerializedName


data class ProfileInfo(
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
        @SerializedName("location")
        var location: String,
        @SerializedName("phone")
        var phone: String,
        @SerializedName("profileImage")
        var profileImage: String
    )
}