package com.example.meyman.domain.utils.models


data class BookingModel(
    val id: Int,
   val result: List<ResultsBookingModel>
)

data class ResultsBookingModel(
    val id: Int,
    val title: String
)
