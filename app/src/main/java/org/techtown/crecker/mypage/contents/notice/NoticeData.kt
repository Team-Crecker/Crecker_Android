package org.techtown.crecker.mypage.contents.notice
import com.google.gson.annotations.SerializedName


data class NoticeData(
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
        @SerializedName("content")
        var content: String,
        @SerializedName("createAt")
        var createAt: String,
        @SerializedName("noticeIdx")
        var noticeIdx: Int,
        @SerializedName("title")
        var title: String,
        @SerializedName("updateAt")
        var updateAt: String?
    )
}