package com.example.hostel_management.REQUESTS

import com.example.hostel_management.REQUESTS.requesters
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api2 {

    @GET("fetch.php")
    fun setType(): Call<requesters>
}