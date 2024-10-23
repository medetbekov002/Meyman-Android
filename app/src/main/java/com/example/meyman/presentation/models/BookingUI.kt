//package com.example.meyman.presentation.models
//
//import com.example.meyman.domain.utils.models.BookingModel
//import com.example.meyman.domain.utils.models.ResultsBookingModel
//import com.google.gson.annotations.SerializedName
//
//data class BookingUI(
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("results")
//    val results: List<ResultsBookingUI>
//)
//
//fun BookingModel.toUI() = BookingUI(
//    id, result.map { it.toUI() }
//)
//
//data class ResultsBookingUI(
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("title")
//    val title: String
//)
//
//fun ResultsBookingModel.toUI() = ResultsBookingUI(
//    id, title
//)