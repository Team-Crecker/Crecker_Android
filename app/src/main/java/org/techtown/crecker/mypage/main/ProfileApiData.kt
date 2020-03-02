package org.techtown.crecker.mypage.main

import com.google.gson.annotations.SerializedName

data class ProfileApiData(
    val `data`: List<Data>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
) {
    data class Data(
        val cash: Int,
        val channelName: String,
        val name: String,
        val profileImage: String
    )
}