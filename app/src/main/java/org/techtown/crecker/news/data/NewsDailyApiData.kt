package org.techtown.crecker.news.data

data class NewsDailyApiData(
    val `data`: List<Data>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
) {
    data class Data(
        val content: String,
        val createAt: String,
        val dailyIdx: Int,
        val subtitle: String,
        val thumbnail: String,
        val title: String,
        val updateAt: String
    )
}