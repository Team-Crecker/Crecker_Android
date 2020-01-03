package org.techtown.crecker.mypage.report.api

import org.techtown.crecker.mypage.report.data.IndividualData
import org.techtown.crecker.mypage.report.data.ReportDetailData
import org.techtown.crecker.mypage.report.data.TotalData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
const val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjU5LCJ0eXBlQWQiOiIwMTAyIiwidHlwZUV4cGVydCI6IjAyMDEiLCJ0eXBlTmV3cyI6IjAzMDEiLCJpYXQiOjE1Nzc4OTI3OTMsImV4cCI6MTU3OTEwMjM5MywiaXNzIjoiaWcifQ.4lygL-0-oMqSXDQj5FSq25WPPuFNQ8ZdsjfqZy2w-mM"

interface ReportService {
    //개별 리포트 데이터 가져오기
    @Headers("token: ${token}")
    @GET("report")
    fun getIndividual(
    ) : Call<IndividualData>

    //토탈 리포트 데이터 가져오기
    @Headers("token: ${token}")
    @GET("report/info")
    fun getTotalReport(
    ) : Call<TotalData>

    //개별리포트에서 요소 클릭 시 데이터 가져오기
    @Headers("token: ${token}")
    @GET("report/{idx}")
    fun getDetailReport(
        @Path("idx") idx : Int
    ) : Call<ReportDetailData>

}