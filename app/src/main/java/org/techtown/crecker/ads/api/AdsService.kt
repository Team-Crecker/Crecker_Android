package org.techtown.crecker.ads.api

import org.techtown.crecker.ads.contents.data.Ads
import org.techtown.crecker.ads.contents.data.AdsRandom
import org.techtown.crecker.ads.contents.data.Detail
import org.techtown.crecker.ads.contents.data.PersonInfo
import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.HashMap

const val TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOjEsInR5cGVFeHBlcnQiOjIsInR5cGVOZXdzIjoiMyIsImlhdCI6MTU3NzcxMzE0MSwiZXhwIjoxNTc4OTIyNzQxLCJpc3MiOiJpZyJ9.-p9SPp-4ojgr8s9gXTT64M7IZuMI-TFIT8BXnlNhzSs"

interface AdsService{
    //광고 메인 랜덤 이미지
    @GET("advertise/ad/random")
    fun getRandomAds(): Call<AdsRandom>

    //이런 광고 어때요?
    @Headers("token: $TOKEN")
    @GET("advertise/ad/interest")
    fun getInterestAds(): Call<Ads>

    //인기순
    @GET("advertise/ad/popular")
    fun getPopularAds(): Call<Ads>

    //최신순
    @GET("advertise/ad/latest")
    fun getLatestAds(): Call<Ads>

    //카테고리별 광고
    @GET("advertise/ad/list/{idx}")
    fun getCategorizedAds(@Path("idx") idx: Int): Call<Ads>

    //AdDetailActivity
    @GET("advertise/ad/detail/{idx}")
    fun getDetailInfo(@Path("idx") idx: Int): Call<Detail>

    //Load AdApplyActivity
    @GET("advertise/ad/apply")
    fun getPersonInfo(): Call<PersonInfo>

    //Post AdApplyActivity
    @FormUrlEncoded
    @POST("advertise/ad/write")
    fun postAdPlan(@FieldMap payLoad: HashMap<String, Any>)
}