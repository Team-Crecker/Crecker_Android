package org.techtown.crecker.home.data

import com.google.gson.annotations.SerializedName
import org.techtown.crecker.membership.data.LoginResultData

data class HomeSupportListData(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("poster")
        val poster : String,
        @SerializedName("title")
        val title : String,
        @SerializedName("host")
        val host : String,
        @SerializedName("dday")
        val dday : Int,
        @SerializedName("newsIdx")
        val newsIdx: Int
    )
}