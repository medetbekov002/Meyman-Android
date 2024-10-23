package com.example.meyman.presentation.models.reservation

import com.example.meyman.domain.utils.models.reservation.ReservationGetModel

data class ReservationGetUI(
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

fun ReservationGetModel.toUI() = ReservationGetUI(adults, check_in_date, check_out_date, children, client_email, housing, id, phone_number, room_name, username)