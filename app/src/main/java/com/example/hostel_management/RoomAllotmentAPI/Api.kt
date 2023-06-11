package com.example.hostel_management.RoomAllotmentAPI

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("RoomAlloted.php")
    fun setProfile(
        @Field("name") name : String,
        @Field("RegNo")  RegNo : String,
        @Field("email") email: String,
        @Field("roomNo")  room : String,

                   ): Call<RegisterResponse>
}