package org.techtown.crecker.ads.contents.data
import com.google.gson.annotations.SerializedName

data class Detail(
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
        @SerializedName("ad")
        var ad: List<Ad>,
        @SerializedName("subscribers")
        var subscribers: Int
    ) {
        data class Ad(
            @SerializedName("adIdx")
            var adIdx: Int,
            @SerializedName("addInfo")
            var addInfo: String,
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
            @SerializedName("companyName")
            var companyName: String,
            @SerializedName("completeDate")
            var completeDate: String,
            @SerializedName("createAt")
            var createAt: String,
            @SerializedName("fullPhoto")
            var fullPhoto: String,
            @SerializedName("isAdd")
            var isAdd: String,
            @SerializedName("isPick")
            var isPick: Int,
            @SerializedName("keyword")
            var keyword: String,
            @SerializedName("preference")
            var preference: String,
            @SerializedName("reward")
            var reward: String,
            @SerializedName("subscribers")
            var subscribers: String,
            @SerializedName("subscribersNum")
            var subscribersNum: Int,
            @SerializedName("subtitle")
            var subtitle: String,
            @SerializedName("summaryPhoto")
            var summaryPhoto: String,
            @SerializedName("thumbnail")
            var thumbnail: String,
            @SerializedName("title")
            var title: String,
            @SerializedName("updateAt")
            var updateAt: String,
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
}