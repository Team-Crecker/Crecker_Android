package org.techtown.crecker.news.data

data class NewsBannerApiData(
    val `data`: List<Data>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
) {
    data class Data(
        val createAt: String,
        val dailyIdx: Int,
        val thumbnail: String
    )
}