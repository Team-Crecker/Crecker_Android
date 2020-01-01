package org.techtown.crecker.membership.api

import org.techtown.crecker.membership.data.SignUpResultData
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SignUpService {
    @FormUrlEncoded
    @POST("/api/auth/signup/")
    fun getSignUpResult():Call<SignUpResultData>
}