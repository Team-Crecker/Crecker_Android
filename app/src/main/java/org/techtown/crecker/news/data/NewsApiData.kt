package org.techtown.crecker.news.data

data class NewsApiData(
    val `data`: List<Data>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
) {
    data class Data(
        val applyCount: String,
        val calendarEnd: String,
        val calendarStart: String,
        val contents: String,
        val createAt: String,
        val host: String,
        val newsIdx: Int,
        val poster: String,
        val subtitle: String,
        val title: String,
        val updateAt: String,
        val url: String,
        val views: Int
    )
}