package org.techtown.crecker.law.data

data class QAdata(
    val `data`: List<Data>,
    val message: String,
    val statusCode: Int,
    val success: Boolean
) {
    data class Data(
        val Qcontent: String,
        val Qtitle: String,
        val answerUpdateAt: Int?,
        val createAt: Int,
        val expertConsultIdx: Int,
        val isComplete: Int,
        val isSecret: Int,
        val views: Int
    )
}