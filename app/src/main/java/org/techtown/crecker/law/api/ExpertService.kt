package org.techtown.crecker.law.api

import org.techtown.crecker.law.data.BetelangApiData
import retrofit2.Call
import retrofit2.http.GET

interface ExpertService{
    @GET("expert/profile")
    fun getBetelang() : Call<BetelangApiData>
}