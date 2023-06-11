package com.example.hostel_management.RequestStatus

data class Status(
    val error: String,
    val users: List<User>
)