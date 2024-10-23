package com.example.meyman.domain.utils.models

data class HostelModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemModel>
)
