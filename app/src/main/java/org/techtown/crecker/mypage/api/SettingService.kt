package org.techtown.crecker.mypage.api

import org.techtown.crecker.ads.api.TOKEN
import org.techtown.crecker.mypage.advertise.data.Interest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.PUT

interface SettingService{
    @Headers("token: $TOKEN")
    @PUT("user/interest")
    fun putUserInterest(@Body param: Interest): Call<Response>
}