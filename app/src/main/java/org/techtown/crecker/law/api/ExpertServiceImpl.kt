package org.techtown.crecker.law.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ExpertServiceImpl {
    private const val BASE_URL = "http://54.180.197.215:3000/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : ExpertService = retrofit.create(ExpertService::class.java)
}