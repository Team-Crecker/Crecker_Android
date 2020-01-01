package org.techtown.crecker.membership.data
import com.google.gson.annotations.SerializedName


data class LoginResultData(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("tokens")
        val tokens: Tokens
    ) {
        data class Tokens(
            @SerializedName("refreshToken")
            val refreshToken: String,
            @SerializedName("token")
            val token: String
        )
    }
}