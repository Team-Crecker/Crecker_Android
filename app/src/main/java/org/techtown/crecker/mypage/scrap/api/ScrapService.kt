package org.techtown.crecker.mypage.scrap.api

import org.techtown.crecker.mypage.scrap.data.ScrapApiData
import retrofit2.Call
import retrofit2.http.GET


interface ScrapService {
    @GET("usernews")
    fun getTotalScrap(
    ) : Call<ScrapApiData>
}