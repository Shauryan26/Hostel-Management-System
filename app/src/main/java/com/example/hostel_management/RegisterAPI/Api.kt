package com.example.hostel_management.RegisterAPI

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("Register.php")
    fun setProfile(
        @Field("Email") name : String,
        @Field("password") age : String,

                   ): Call<com.example.hostel_management.RegisterAPI.Response>
}