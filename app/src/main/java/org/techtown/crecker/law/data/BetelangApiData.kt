package org.techtown.crecker.law.data

import com.google.gson.annotations.SerializedName

data class BetelangApiData(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val category: Int,
        @SerializedName("description")
        val betelang_aff: String, // 전문가 소속
        @SerializedName("experience")
        val betelang_Clear_Num: Int,
        val expertIdx: Int,
        @SerializedName("name")
        val betelang_Name: String,
        @SerializedName("photo")
        val profile : String
    )
}
