package com.example.meyman.presentation.models.reservation

data class ReservationUI(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ReservationResultUI>
)