package org.techtown.crecker.mypage.api

import org.techtown.crecker.mypage.advertise.data.BasicInfo
import org.techtown.crecker.mypage.advertise.data.TagAdData
import org.techtown.crecker.mypage.advertise.data.UserAdData
import org.techtown.crecker.mypage.advertise.data.VideoInfo
import retrofit2.Call
import retrofit2.http.*

interface UserAdService {
    //My Ad
    @GET("userad/{idx}")
    fun getUserAds(@Path("idx") idx: Int): Call<UserAdData>

    //My Ad
    @GET("userad/{idx}")
    fun getTagAds(@Path("idx") idx: Int): Call<TagAdData>


    //바깥쪽
    @GET("userad/length")
    fun getBasicInfo(): Call<BasicInfo>

    //등록일, 썸네일 get
    @FormUrlEncoded
    @POST("userad/auth/auth/auth")
    fun getVideoInfo(@FieldMap payLoad: HashMap<String, Any>): Call<VideoInfo>

    //영상 인증
    @FormUrlEncoded
    @POST("userad/auth")
    fun postVideoInfo(@FieldMap payLoad: HashMap<String, Any>): Call<Response>
}