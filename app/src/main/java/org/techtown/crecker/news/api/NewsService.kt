package org.techtown.crecker.news.api

import org.techtown.crecker.news.data.NewsApiData
import org.techtown.crecker.news.data.NewsDailyApiData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

const val sampleToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOiIwMTAyIiwidHlwZUV4cGVydCI6IjAyMDEiLCJ0eXBlTmV3cyI6IjAzMDEiLCJpYXQiOjE1Nzc4OTI3OTMsImV4cCI6MTU3OTEwMjM5MywiaXNzIjoiaWcifQ.4lygL-0-oMqSXDQj5FSq25WPPuFNQ8ZdsjfqZy2w-mM"
interface NewsService {
    @Headers("token: $sampleToken")
    @GET("news/recommand/{flag}")
    fun getSupportNews(
        @Path("flag") flag : Int
    ) : Call<NewsApiData>

    @Headers("token: $sampleToken")
    @GET("news/support")
    fun getSupportAllNews() : Call<NewsApiData>

    @Headers("token: $sampleToken")
    @GET("news/daily")
    fun getDailyAllNews() : Call<NewsDailyApiData>

    @Headers("token: $sampleToken")
    @GET("news/daily/{idx}")
    fun getDailyNews(
        @Path("idx") idx : Int
    ) : Call<NewsDailyApiData>


}