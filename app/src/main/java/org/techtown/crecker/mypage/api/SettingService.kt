package org.techtown.crecker.mypage.api

import org.techtown.crecker.ads.api.TOKEN
import org.techtown.crecker.mypage.advertise.data.Interest
import org.techtown.crecker.mypage.setting.ProfileInfo
import retrofit2.Call
import retrofit2.http.*
import okhttp3.RequestBody
import retrofit2.http.Multipart





interface SettingService{
    @Headers("token: $TOKEN")
    @PUT("user/interest")
    fun putUserInterest(@Body param: Interest): Call<Response>

    @Headers("token: $TOKEN")
    @GET("user")
    fun getProfileInfo(): Call<ProfileInfo>

    @Headers("token: $TOKEN")
    @Multipart
    @PUT("user")
    fun updateProfileInfo(@PartMap params: HashMap<String, RequestBody>)
            : Call<Response>
}