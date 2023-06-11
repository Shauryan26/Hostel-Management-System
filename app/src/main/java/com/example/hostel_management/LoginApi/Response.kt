package com.example.hostel_management.LoginApi

data class Response(
    val error: String,
    val users: List<User>
)