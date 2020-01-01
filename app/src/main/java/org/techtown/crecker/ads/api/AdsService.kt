package org.techtown.crecker.ads.api

import org.techtown.crecker.ads.contents.data.*
import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.HashMap

const val TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOiIwMTAyIiwidHlwZUV4cGVydCI6IjAyMDEiLCJ0eXBlTmV3cyI6IjAzMDEiLCJpYXQiOjE1Nzc4OTI3OTMsImV4cCI6MTU3OTEwMjM5MywiaXNzIjoiaWcifQ.4lygL-0-oMqSXDQj5FSq25WPPuFNQ8ZdsjfqZy2w-mM"

interface AdsService{
    //광고 메인 랜덤 이미지
    @Headers("token: $TOKEN")
    @GET("advertise/ad/random")
    fun getRandomAds(): Call<AdsRandom>

    //이런 광고 어때요?
    @Headers("token: $TOKEN")
    @GET("advertise/ad/interest")
    fun getInterestAds(): Call<Ads>

    //인기순
    @Headers("token: $TOKEN")
    @GET("advertise/ad/popular")
    fun getPopularAds(): Call<Ads>

    //최신순
    @Headers("token: $TOKEN")
    @GET("advertise/ad/latest")
    fun getLatestAds(): Call<Ads>

    //카테고리별 광고
    @Headers("token: $TOKEN")
    @GET("advertise/ad/list/{idx}")
    fun getCategorizedAds(@Path("idx") idx: String): Call<Ads>

    //AdDetailActivity
    @Headers("token: $TOKEN")
    @GET("advertise/ad/detail/{idx}")
    fun getDetailInfo(@Path("idx") idx: Int): Call<Detail>

    //Load AdApplyActivity
    @Headers("token: $TOKEN")
    @GET("advertise/ad/apply")
    fun getPersonInfo(): Call<PersonInfo>

    //Post AdApplyActivity
    @Headers("token: $TOKEN")
    @FormUrlEncoded
    @POST("advertise/ad/write")
    fun postAdPlan(@FieldMap payLoad: HashMap<String, Any>): Call<PostResponse>
}