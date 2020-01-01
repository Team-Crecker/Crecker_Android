package org.techtown.crecker.membership.api

import org.techtown.crecker.membership.data.LoginResultData
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {
    @FormUrlEncoded
    @POST("auth/login")
    fun getUser(@FieldMap map: HashMap<String, Any>): Call<LoginResultData>
}