package com.example.meyman.domain.utils.models.reservation

data class ReservationGetModel(
    val adults: Int,
    val check_in_date: String,
    val check_out_date: String,
    val children: Int,
    val client_email: String,
    val housing: Int,
    val id: Int,
    val phone_number: String,
    val room_name: String,
    val username: String
)