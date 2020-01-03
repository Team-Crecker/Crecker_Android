package org.techtown.crecker.home.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HomeFragServiceImpl {
    private const val BASE_URL = "http://54.180.197.215:3000/api/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bannerService : HomeFragService = retrofit.create(HomeFragService ::class.java)
    val adsService : HomeFragService = retrofit.create(HomeFragService::class.java)
    val supportService : HomeFragService = retrofit.create(HomeFragService ::class.java)

}