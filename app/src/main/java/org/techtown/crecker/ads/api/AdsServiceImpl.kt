package org.techtown.crecker.ads.api

import com.amn.easysharedpreferences.EasySharedPreference
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://54.180.197.215:3000/api/"

private val interceptor = object : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = EasySharedPreference.getString("token", "")

        val newRequest = chain.request().newBuilder().addHeader("token", token).build()

        return chain.proceed(newRequest)
    }
}

private val client = OkHttpClient.Builder().apply {
    interceptors().add(interceptor)
}.build()

object AdsServiceImpl {
    val service: AdsService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(AdsService::class.java)
}