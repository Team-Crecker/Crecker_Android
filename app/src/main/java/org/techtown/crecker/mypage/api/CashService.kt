package org.techtown.crecker.mypage.api

import org.techtown.crecker.mypage.contents.usage.CashData
import retrofit2.Call
import retrofit2.http.*

interface CashService {
    //캐시 조회
    @GET("cash")
    fun getCashData(): Call<CashData>

    //인출하기
    @POST("cash/withdraw")
    fun postWithdraw(): Call<Response>
}