package org.techtown.crecker.mypage.api

import org.techtown.crecker.ads.api.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserAdServiceImpl {
    val service: UserAdService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAdService::class.java)
}