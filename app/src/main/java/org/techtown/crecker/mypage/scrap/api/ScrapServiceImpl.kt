package org.techtown.crecker.mypage.scrap.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ScrapServiceImpl {
    private const val BASE_URL = "http://54.180.197.215:3000/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : ScrapService = retrofit.create(ScrapService::class.java)
}