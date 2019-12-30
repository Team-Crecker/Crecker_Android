package org.techtown.crecker.ads.api

import org.techtown.crecker.ads.contents.data.Ads
import org.techtown.crecker.ads.contents.data.AdsRandom
import org.techtown.crecker.ads.contents.data.PersonInfo
import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.HashMap

interface AdsService {
    //광고 메인 랜덤 이미지
    @GET("advertise/ad/random")
    fun getRandomAds(): Call<AdsRandom>

    //이런 광고 어때요?
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
    fun getDetailInfo(): Call<Ads>

    //Load AdApplyActivity
    @GET("advertise/ad/apply")
    fun getPersonInfo(): Call<PersonInfo>

    //Post AdApplyActivity
    @FormUrlEncoded
    @POST("advertise/ad/write")
    fun postAdPlan(@FieldMap payLoad: HashMap<String, Any>)
}