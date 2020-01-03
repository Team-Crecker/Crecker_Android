package org.techtown.crecker.ads.contents.data

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("message")
    var message: String,
    @SerializedName("statusCode")
    var statusCode: Int,
    @SerializedName("success")
    var success: Boolean
)