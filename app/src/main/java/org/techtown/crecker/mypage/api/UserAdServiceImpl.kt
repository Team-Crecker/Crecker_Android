package org.techtown.crecker.mypage.api

import com.amn.easysharedpreferences.EasySharedPreference
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.techtown.crecker.ads.api.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserAdServiceImpl {
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

    val service: UserAdService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(UserAdService::class.java)
}