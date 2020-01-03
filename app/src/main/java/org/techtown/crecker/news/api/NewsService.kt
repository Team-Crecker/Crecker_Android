package org.techtown.crecker.news.api

import org.techtown.crecker.news.data.*
import retrofit2.Call
import retrofit2.http.*

interface NewsService {
    // 정렬방식에 따른 뉴스 불러오기
    @GET("news/recommand/{flag}")
    fun getSupportNews(
        @Path("flag") flag : Int
    ) : Call<NewsApiData>
//  뉴스 전체 불러오기
    @GET("news/support")
    fun getSupportAllNews(
) : Call<NewsApiData>

//   특정 뉴스 불러오기
    @GET("news/support/{idx}")
    fun getSupportNewsMore(
    @Path("idx") idx : Int
    ) : Call<NewsApiData>

// 데일리 뉴스 전체 불러오기
    @GET("news/daily")
    fun getDailyAllNews(
) : Call<NewsDailyApiData>

//   특정 데일리 뉴스 불러오기
    @GET("news/daily/{idx}")
    fun getDailyNews(
        @Path("idx") idx : Int
    ) : Call<NewsDailyApiData>

//    뉴스 배너 데이터 불러오기
    @GET("news/card")
    fun getBannerNews(
) : Call<NewsBannerApiData>

//    스크랩 등록
    @POST("news/scrap")
    fun postScrap(
    @Body
    newsIdx : NewsIdx
    ) : Call<ScrapResultData>

    //    스크랩 삭제
    @HTTP(method = "DELETE", path = "news/scrap", hasBody = true)
    fun deleteScrap(
        @Body newIdx : NewsIdx
    ) : Call<ScrapResultData>

}