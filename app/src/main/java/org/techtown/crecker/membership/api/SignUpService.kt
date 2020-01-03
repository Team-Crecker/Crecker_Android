package org.techtown.crecker.membership.api

import org.techtown.crecker.membership.data.SignUpData
import org.techtown.crecker.membership.data.SignUpResultData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {

    @POST("auth/signup/")
    fun postSignUpResult(
        @Body
        signUp : SignUpData
    ):Call<SignUpResultData>
}