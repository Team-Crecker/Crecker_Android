package org.techtown.crecker.law.data

data class ExpertLawListData(
    val counseling_state : String, // 답변 완료 or 답변 예정
    val lock : Boolean,            // 비밀 게시 확인
    val title : String,
    val content : String
)