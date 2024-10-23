package com.example.meyman.domain.utils.models.reservation

data class ReservationModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ReservationResultModel>
)