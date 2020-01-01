package org.techtown.crecker.membership.data
import com.google.gson.annotations.SerializedName


data class SignUpResultData(
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("success")
    val success: Boolean
)