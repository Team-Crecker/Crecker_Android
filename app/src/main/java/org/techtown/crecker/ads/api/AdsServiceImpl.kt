package org.techtown.crecker.ads.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://192.168.200.127:3000/api/"

object AdsServiceImpl {
    val service: AdsService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AdsService::class.java)
}