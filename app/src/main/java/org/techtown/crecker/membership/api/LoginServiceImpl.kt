package org.techtown.crecker.membership.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginServiceImpl {
    private const val BASE_URL = "http://192.168.43.233:3000/api/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : LoginService = retrofit.create(LoginService::class.java)
}