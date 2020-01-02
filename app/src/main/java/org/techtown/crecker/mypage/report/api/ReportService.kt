package org.techtown.crecker.mypage.report.api

import org.techtown.crecker.mypage.report.data.IndividualData
import org.techtown.crecker.mypage.report.data.TotalData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

const val sampleToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOjEsInR5cGVFeHBlcnQiOjIsInR5cGVOZXdzIjoiMyIsImlhdCI6MTU3NzcwNTEzMywiZXhwIjoxNTc4OTE0NzMzLCJpc3MiOiJpZyJ9.mjDVOk20owpkvpOejpyBmZSbbFw9KM-iP7lS4Tsn5Pw"
interface ReportService {

    @Headers("token: $sampleToken")
    @GET("report")
    fun getIndividual() : Call<IndividualData>

    @Headers("token: $sampleToken")
    @GET("report/info")
    fun getTotalReport() : Call<TotalData>


}