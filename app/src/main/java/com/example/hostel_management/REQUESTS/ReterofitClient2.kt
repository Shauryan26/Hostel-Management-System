package com.example.hostel_management.REQUESTS

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object ReterofitClient2 {

    val api : Api2 by lazy{
        Log.i("Tag","BadySD")
        Retrofit.Builder()
            .baseUrl("http://192.168.105.96\\HostelManagement\\")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api2::class.java)
    }
}