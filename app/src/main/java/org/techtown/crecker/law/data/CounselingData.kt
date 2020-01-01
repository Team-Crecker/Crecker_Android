package org.techtown.crecker.law.data

import com.google.gson.annotations.SerializedName

class CounselingData (
    @SerializedName("name")
    val Cname : String,
    @SerializedName("Cdate")
    val Cdate : String,
    @SerializedName("Ctime")
    val Ctime : String,
    @SerializedName("expertConsultIdx")
    val expertCosultIdx : Int,
    @SerializedName("Ccontent")
    val Ccount : String
)