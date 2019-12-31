package org.techtown.crecker.ads.contents.data
import com.google.gson.annotations.SerializedName


data class Detail(
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
        @SerializedName("addInfo")
        var addInfo: Any?,
        @SerializedName("applyFrom")
        var applyFrom: String,
        @SerializedName("applyTo")
        var applyTo: String,
        @SerializedName("campaignInfo")
        var campaignInfo: String,
        @SerializedName("campaignMission")
        var campaignMission: String,
        @SerializedName("cash")
        var cash: String,
        @SerializedName("categoryCode")
        var categoryCode: String,
        @SerializedName("choice")
        var choice: String,
        @SerializedName("completeDate")
        var completeDate: String,
        @SerializedName("createAt")
        var createAt: String,
        @SerializedName("fullPhoto")
        var fullPhoto: String,
        @SerializedName("keyword")
        var keyword: String,
        @SerializedName("preference")
        var preference: String,
        @SerializedName("reward")
        var reward: String,
        @SerializedName("subtitle")
        var subtitle: String,
        @SerializedName("summaryPhoto")
        var summaryPhoto: String,
        @SerializedName("thumbnail")
        var thumbnail: String,
        @SerializedName("title")
        var title: String,
        @SerializedName("updateAt")
        var updateAt: Any?,
        @SerializedName("uploadFrom")
        var uploadFrom: String,
        @SerializedName("uploadTo")
        var uploadTo: String,
        @SerializedName("url")
        var url: String,
        @SerializedName("views")
        var views: Int
    )
}