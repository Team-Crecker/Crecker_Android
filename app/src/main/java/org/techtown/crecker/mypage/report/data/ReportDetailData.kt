package org.techtown.crecker.mypage.report.data

data class ReportDetailData(
    val `data`: List<Data>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
) {
    data class Data(
        val cash: String,
        val companyName: String,
        val likes: Int,
        val title: String,
        val updateAt: String,
        val uploadTo: String,
        val userAdIdx: Int,
        val views1: Int,
        val views2: Int,
        val views3: Int,
        val views4: Int,
        val views5: Int
    )
}