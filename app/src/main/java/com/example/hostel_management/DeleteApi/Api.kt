package com.example.hostel_management.DeleteApi

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("delete.php")
    fun setProfile(
        @Field("Email") name : String,
        @Field("RegNo") age : String,

                   ): Call<com.example.hostel_management.DeleteApi.Response>
}