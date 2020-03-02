package org.techtown.crecker.mypage.api

import org.techtown.crecker.mypage.advertise.data.Interest
import org.techtown.crecker.mypage.setting.ProfileInfo
import retrofit2.Call
import retrofit2.http.*
import okhttp3.RequestBody
import org.techtown.crecker.mypage.contents.notice.NoticeData
import org.techtown.crecker.mypage.main.ProfileApiData
import retrofit2.http.Multipart

interface SettingService{
    @PUT("user/interest")
    fun putUserInterest(@Body param: Interest): Call<Response>

    @GET("user")
    fun getProfileInfo(): Call<ProfileInfo>

    @Multipart
    @PUT("user")
    fun updateProfileInfo(@PartMap params: HashMap<String, RequestBody>)
            : Call<Response>

    @GET("notice")
    fun getNotice(): Call<NoticeData>

    @GET("notice/{idx}")
    fun getDetailNotice(@Path("idx") idx: Int): Call<NoticeData>

    @GET("user/profile")
    fun getPageProfile() : Call<ProfileApiData>
}