package org.techtown.crecker.ads.contents

data class AdData(
    val img_url : String,
    val img_local : Int,
    val title_kor : String,
    val title_eng : String?,
    val price : Int,
    val dday : Int?
)