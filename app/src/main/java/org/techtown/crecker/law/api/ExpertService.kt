package org.techtown.crecker.law.api

import org.techtown.crecker.law.data.*
import retrofit2.Call
import retrofit2.http.*

interface ExpertService{
    // Expert 메인 화면 전문가 리스트
    @GET("expert/profile")
    fun getBetelang(
    ) : Call<BetelangApiData>

    //Law탭에서 보이는 상담내역 리스트
    @GET("expert/qa/law")
    fun getLawAnswer(
    ) : Call<QAdata>

    //상담내역 리스트를 클릭 시 세부사항 내역
    @GET("expert/qa/law/{idx}")
    fun getLawDetail(
        @Path("idx") idx : Int
    ): Call<QAdetailData>

    //질문 리스트 작성
    @POST("expert/qa/law")
    fun postLawQuestion(
        @Body questionData : QuestionData
    ) : Call<QuestionResult>

    //정확한 상담시간 작성
    @PUT("expert/qa/apply")
    fun putCounseling(
        @Body counseling : CounselingData
    ) : Call<CounselingResult>
}