package org.techtown.crecker.law.api


import com.amn.easysharedpreferences.EasySharedPreference
import org.techtown.crecker.law.data.*
import retrofit2.Call
import retrofit2.http.*


const val sampleToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOiIwMTAyIiwidHlwZUV4cGVydCI6IjAyMDEiLCJ0eXBlTmV3cyI6IjAzMDEiLCJpYXQiOjE1Nzc4OTI3OTMsImV4cCI6MTU3OTEwMjM5MywiaXNzIjoiaWcifQ.4lygL-0-oMqSXDQj5FSq25WPPuFNQ8ZdsjfqZy2w-mM"
interface ExpertService{
    // Expert 메인 화면 전문가 리스트
    @Headers("token: $sampleToken")
    @GET("expert/profile")
    fun getBetelang(
    ) : Call<BetelangApiData>

    //Law탭에서 보이는 상담내역 리스트
    @Headers("token: $sampleToken")
    @GET("expert/qa/law")
    fun getLawAnswer(
//        @Path("header_token") header_token : String
    ) : Call<QAdata>

    //상담내역 리스트를 클릭 시 세부사항 내역
    @Headers("token: $sampleToken")
    @GET("expert/qa/law/{idx}")
    fun getLawDetail(
        @Path("idx") idx : Int
    ): Call<QAdetailData>

    //질문 리스트 작성
    @Headers("token: $sampleToken")
    @POST("expert/qa/law")
    fun postLawQuestion(
        @Body questionData : QuestionData
    ) : Call<QuestionResult>

    //정확한 상담시간 작성
    @Headers("token: $sampleToken")
    @PUT("expert/qa/apply")
    fun putCounseling(
        @Body counseling : CounselingData
    ) : Call<CounselingResult>
}