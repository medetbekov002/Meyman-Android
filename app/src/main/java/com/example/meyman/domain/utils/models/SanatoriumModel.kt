package com.example.meyman.domain.utils.models

data class SanatoriumModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemModel>
)