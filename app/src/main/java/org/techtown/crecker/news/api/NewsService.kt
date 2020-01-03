package org.techtown.crecker.news.api

import org.techtown.crecker.news.data.*
import retrofit2.Call
import retrofit2.http.*

const val sampleToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOiIwMTAyIiwidHlwZUV4cGVydCI6IjAyMDEiLCJ0eXBlTmV3cyI6IjAzMDEiLCJpYXQiOjE1Nzc4OTI3OTMsImV4cCI6MTU3OTEwMjM5MywiaXNzIjoiaWcifQ.4lygL-0-oMqSXDQj5FSq25WPPuFNQ8ZdsjfqZy2w-mM"
interface NewsService {
    // 정렬방식에 따른 뉴스 불러오기
    @Headers("token: $sampleToken")
    @GET("news/recommand/{flag}")
    fun getSupportNews(
        @Path("flag") flag : Int
    ) : Call<NewsApiData>
//  뉴스 전체 불러오기
    @Headers("token: $sampleToken")
    @GET("news/support")
    fun getSupportAllNews() : Call<NewsApiData>

//   특정 뉴스 불러오기
    @Headers("token: $sampleToken")
    @GET("news/support/{idx}")
    fun getSupportNewsMore(
    @Path("idx") idx : Int
    ) : Call<NewsApiData>

// 데일리 뉴스 전체 불러오기
    @Headers("token: $sampleToken")
    @GET("news/daily")
    fun getDailyAllNews() : Call<NewsDailyApiData>

//   특정 데일리 뉴스 불러오기
    @Headers("token: $sampleToken")
    @GET("news/daily/{idx}")
    fun getDailyNews(
        @Path("idx") idx : Int
    ) : Call<NewsDailyApiData>

//    뉴스 배너 데이터 불러오기
    @Headers("token: $sampleToken")
    @GET("news/card")
    fun getBannerNews() : Call<NewsBannerApiData>

//    스크랩 등록
    @Headers("token: $sampleToken")
    @POST("news/scrap")
    fun postScrap(
    @Body
    newsIdx : NewsIdx
    ) : Call<ScrapResultData>

    //    스크랩 삭제
    @Headers("token: $sampleToken")
    @HTTP(method = "DELETE", path = "news/scrap", hasBody = true)
    fun deleteScrap(
        @Body newIdx : NewsIdx
    ) : Call<ScrapResultData>


}