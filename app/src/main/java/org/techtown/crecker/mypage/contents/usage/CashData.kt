package org.techtown.crecker.mypage.contents.usage

import com.google.gson.annotations.SerializedName

data class CashData(
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
        @SerializedName("cash")
        var cash: Int,
        @SerializedName("cashAllowed")
        var cashAllowed: Int,
        @SerializedName("history")
        var history: List<History>
    ) {
        data class History(
            @SerializedName("date")
            var date: String,
            @SerializedName("isIn")
            var isIn: String,
            @SerializedName("price")
            var price: String,
            @SerializedName("title")
            var title: String
        )
    }
}