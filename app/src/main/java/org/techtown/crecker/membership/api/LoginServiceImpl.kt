package org.techtown.crecker.membership.api

import com.amn.easysharedpreferences.EasySharedPreference
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginServiceImpl {

    private const val BASE_URL = "http://54.180.197.215:3000/api/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : LoginService = retrofit.create(LoginService::class.java)
}