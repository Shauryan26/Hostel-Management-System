package com.example.hostel_management.DeleteApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReterofitClient1 {

    val api : Api by lazy{
        Retrofit.Builder()
            .baseUrl("http://192.168.105.96\\HostelManagement\\")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}