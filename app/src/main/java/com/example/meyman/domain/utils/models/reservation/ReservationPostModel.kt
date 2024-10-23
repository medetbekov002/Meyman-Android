package com.example.meyman.domain.utils.models.reservation

data class ReservationPostModel(
    val housing: Int,
    val check_in_date: String,
    val check_out_date: String,
    val username: String,
    val client_email: String,
    val phone_number: String,
    val adults: Int,
    val children: Int
)