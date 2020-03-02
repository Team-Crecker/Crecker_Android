package org.techtown.crecker.mypage.report.data

data class IndividualData(
    val `data`: List<Data>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
) {
    data class Data(
        val categoryName : String,
//        val companyName: String,
        val likes: Int,
        val title: String,
        val userAdIdx: Int,
        val views1: Int
    )
}