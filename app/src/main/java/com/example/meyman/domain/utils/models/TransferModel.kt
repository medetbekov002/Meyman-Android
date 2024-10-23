package com.example.meyman.domain.utils.models

data class TransferModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TransferItemModel>
)

data class TransferItemModel(
    val destination_location: String,
    val different_pickup_places: Boolean,
    val pickup_date: String,
    val pickup_time: String,
    val return_date: String,
    val return_location: String,
    val return_time: String,
    val transfer_location: String,
    val with_driver: Boolean
)
