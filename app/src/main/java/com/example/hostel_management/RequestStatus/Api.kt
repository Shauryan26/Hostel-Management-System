package com.example.hostel_management.RequestStatus

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("roomstatus.php")
    fun setProfile(
        @Field("Email") name : String,
                   ): Call<Status>
}