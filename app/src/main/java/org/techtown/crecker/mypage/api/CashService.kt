package org.techtown.crecker.mypage.api

import org.techtown.crecker.ads.api.TOKEN
import org.techtown.crecker.mypage.contents.usage.CashData
import retrofit2.Call
import retrofit2.http.*

interface CashService {
    //캐시 조회
    @Headers("token: $TOKEN")
    @GET("cash")
    fun getCashData(): Call<CashData>

    //인출하기
    @Headers("token: $TOKEN")
    @FormUrlEncoded
    @POST("cash/withdraw")
    fun postAdPlan(@FieldMap payLoad: HashMap<String, Any>): Call<Response>
}