package org.techtown.crecker.membership.api

import org.techtown.crecker.membership.data.SignUpResultData
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SignUpService {
    @FormUrlEncoded
    @POST("auth/signup/")
    fun getSignUpResult(@FieldMap map:HashMap<String,Any>):Call<SignUpResultData>
}