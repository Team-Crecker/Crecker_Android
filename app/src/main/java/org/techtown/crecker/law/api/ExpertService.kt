package org.techtown.crecker.law.api


import com.amn.easysharedpreferences.EasySharedPreference
import org.techtown.crecker.law.data.*
import org.techtown.crecker.mypage.scrap.api.token
import retrofit2.Call
import retrofit2.http.*

interface ExpertService{
    // Expert 메인 화면 전문가 리스트
    @Headers("token: ${token}")
    @GET("expert/profile")
    fun getBetelang(
    ) : Call<BetelangApiData>

    //Law탭에서 보이는 상담내역 리스트
    @Headers("token: ${token}")
    @GET("expert/qa/law")
    fun getLawAnswer(
    ) : Call<QAdata>

    //상담내역 리스트를 클릭 시 세부사항 내역
    @Headers("token: ${token}")
    @GET("expert/qa/law/{idx}")
    fun getLawDetail(
        @Path("idx") idx : Int
    ): Call<QAdetailData>

    //질문 리스트 작성
    @Headers("token: ${token}")
    @POST("expert/qa/law")
    fun postLawQuestion(
        @Body questionData : QuestionData
    ) : Call<QuestionResult>

    //정확한 상담시간 작성
    @Headers("token: ${token}")
    @PUT("expert/qa/apply")
    fun putCounseling(
        @Body counseling : CounselingData
    ) : Call<CounselingResult>
}