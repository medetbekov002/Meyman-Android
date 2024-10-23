package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.BookingModel
import com.example.meyman.domain.utils.models.ResultsBookingModel
import com.google.gson.annotations.SerializedName

data class BookingDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<ResultsBooking>
)

fun BookingDto.toDomain() = BookingModel(
    id, results.map { it.toDomain() }
)

data class ResultsBooking(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)

fun ResultsBooking.toDomain() = ResultsBookingModel(
    id, title
)