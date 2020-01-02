package org.techtown.crecker.mypage.api
import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("message")
    var message: String,
    @SerializedName("statusCode")
    var statusCode: Int,
    @SerializedName("success")
    var success: Boolean
)