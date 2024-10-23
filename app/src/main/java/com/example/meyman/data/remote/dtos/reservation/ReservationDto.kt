package com.example.meyman.data.remote.dtos.reservation


data class ReservationDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ReservationResultDto>
)
