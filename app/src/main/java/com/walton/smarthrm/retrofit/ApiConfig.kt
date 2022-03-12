package com.walton.smarthrm.retrofit

import com.walton.smarthrm.model.UserLogin
import com.walton.smarthrm.model.UserLoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiConfig {

    @Headers("Content-Type: application/json")
    @POST("acl/login")
    fun userLogin(@Body userLogin: UserLogin): Call<UserLoginResponse>


    @Headers("Content-Type: application/json")
    @POST("user/getUserList")
    fun getUserList(@Body userLogin: UserLogin): Call<UserLoginResponse>

}