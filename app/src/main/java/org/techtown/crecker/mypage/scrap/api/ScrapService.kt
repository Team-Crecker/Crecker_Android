package org.techtown.crecker.mypage.scrap.api

import org.techtown.crecker.mypage.scrap.data.ScrapApiData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
const val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOiIwMTAyIiwidHlwZUV4cGVydCI6IjAyMDEiLCJ0eXBlTmV3cyI6IjAzMDEiLCJpYXQiOjE1Nzc4OTI3OTMsImV4cCI6MTU3OTEwMjM5MywiaXNzIjoiaWcifQ.4lygL-0-oMqSXDQj5FSq25WPPuFNQ8ZdsjfqZy2w-mM"

interface ScrapService {
    @Headers("token: ${token}")
    @GET("usernews")
    fun getTotalScrap(
    ) : Call<ScrapApiData>
}