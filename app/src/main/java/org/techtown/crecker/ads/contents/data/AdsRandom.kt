package org.techtown.crecker.ads.contents.data
import com.google.gson.annotations.SerializedName


data class AdsRandom(
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
        @SerializedName("dday")
        var dday: Int,
        @SerializedName("subtitle")
        var subtitle: String,
        @SerializedName("thumbnail")
        var thumbnail: String,
        @SerializedName("title")
        var title: String
    )
}