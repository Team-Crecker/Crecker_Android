package org.techtown.crecker.ads.contents

data class AdData(
    val img_url : String,
    val img_local : Int,
    val title : String,
    val price : Int,
    val dday : Int?
)