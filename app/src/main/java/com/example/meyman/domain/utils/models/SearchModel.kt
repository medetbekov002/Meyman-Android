package com.example.meyman.domain.utils.models

data class SearchModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<SearchItemModel>
)

data class SearchItemModel(
    val adults: Int,
    val check_in_date: String,
    val check_out_date: String,
    val children: Int,
    val destination: String,
    val infants: Int,
    val pets: Int,
    val teens: Int
)
