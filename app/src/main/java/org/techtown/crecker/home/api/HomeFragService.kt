package org.techtown.crecker.home.api

import org.techtown.crecker.home.data.HomeAdsListData
import org.techtown.crecker.home.data.HomeBannerImgData
import org.techtown.crecker.home.data.HomeSupportListData
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.GET

interface HomeFragService {

    @GET("advertise/ad/interest")
    fun getAdsListData() : Call<HomeAdsListData>

    @GET("news/recommand/2")
    fun getSupportListData() : Call<HomeSupportListData>

    @GET("home/")
    fun getBannerImgData() : Call<HomeBannerImgData>
}