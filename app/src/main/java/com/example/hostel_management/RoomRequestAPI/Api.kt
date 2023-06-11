package com.example.hostel_management.RoomRequestAPI

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("requestroom.php")
    fun setProfile(
        @Field("name") name : String,
        @Field("RegNo")  RegNo : String,
        @Field("email") email: String,
        @Field("room")  room : String,

                   ): Call<RegisterResponse>
}