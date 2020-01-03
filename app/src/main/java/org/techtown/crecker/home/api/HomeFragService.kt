package org.techtown.crecker.home.api

import org.techtown.crecker.home.data.HomeAdsListData
import org.techtown.crecker.home.data.HomeBannerImgData
import org.techtown.crecker.home.data.HomeSupportListData
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.GET
import retrofit2.http.Headers

const val sampleToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOiIwMTAyIiwidHlwZUV4cGVydCI6IjAyMDEiLCJ0eXBlTmV3cyI6IjAzMDEiLCJpYXQiOjE1Nzc4OTI3OTMsImV4cCI6MTU3OTEwMjM5MywiaXNzIjoiaWcifQ.4lygL-0-oMqSXDQj5FSq25WPPuFNQ8ZdsjfqZy2w-mM"

interface HomeFragService {

    @Headers("token: ${sampleToken}")
    @GET("advertise/ad/interest")
    fun getAdsListData() : Call<HomeAdsListData>

    @Headers("token: ${sampleToken}")
    @GET("news/recommand/2")
    fun getSupportListData() : Call<HomeSupportListData>

    @Headers("token: ${sampleToken}")
    @GET("home/")
    fun getBannerImgData() : Call<HomeBannerImgData>
}