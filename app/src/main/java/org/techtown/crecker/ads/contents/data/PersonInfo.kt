package org.techtown.crecker.ads.contents.data
import com.google.gson.annotations.SerializedName


data class PersonInfo(
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
        @SerializedName("youtubeUrl")
        var youtubeUrl: String
    )
}