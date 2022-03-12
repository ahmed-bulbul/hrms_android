package com.walton.smarthrm.retrofit

import com.walton.smarthrm.model.UserListResponse
import com.walton.smarthrm.model.UserLogin
import com.walton.smarthrm.model.UserLoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiConfig {

    @Headers("Content-Type: application/json")
    @POST("acl/login")
    fun userLogin(@Body userLogin: UserLogin): Call<UserLoginResponse>


    @GET("acl/user/getUserList")
    fun getUserList(
        @Header("Authorization") token: String,
        @Query("pageNum") pageNum: Int,
        @Query("pageSize") pageSize: Int,
        @Query("rEntityName") rEntityName: String,
        @Query("rReqType") rReqType: String
        ): Call<UserListResponse>

}