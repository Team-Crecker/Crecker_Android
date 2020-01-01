package org.techtown.crecker.law.data

import com.google.gson.annotations.SerializedName

data class QuestionData(
    @SerializedName("Qtitle")
    val qTitle : String,
    @SerializedName("Qcontent")
    val qContent : String,
    @SerializedName("categoryCode")
    val categoryCode : String = "0201",
    @SerializedName("isSecret")
    val isSecret : Int
)