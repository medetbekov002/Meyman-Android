package com.example.meyman.data.remote.dtos.reservation

import com.example.meyman.domain.utils.models.reservation.ReservationResultModel

data class ReservationResultDto(
    val adults: Int,
    val check_in_date: String,
    val check_out_date: String,
    val children: Int,
    val client_email: String,
    val housing: Int,
    val id: Int,
    val phone_number: String,
    val room_name: String? = null,
    val username: String
)

fun ReservationResultDto.toDomain() = ReservationResultModel(
    adults, check_in_date, check_out_date, children, client_email, housing, id, phone_number, room_name, username
)