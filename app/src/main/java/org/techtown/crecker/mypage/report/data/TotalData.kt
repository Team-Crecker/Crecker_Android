package org.techtown.crecker.mypage.report.data

data class TotalData(
    val `data`: Data,
    val message: String,
    val statusCode: Int,
    val success: Boolean
) {
    data class Data(
        val er: Int,
        val top: List<Top>,
        val totalCosts: Int,
        val totalLikes: Int,
        val totalViews: Int,
        val totalViews1: Int,
        val totalViews2: Int,
        val totalViews3: Int,
        val totalViews4: Int,
        val totalViews5: Int
    ) {
        data class Top(
            val name: String,
            val views: Int
        )
    }
}