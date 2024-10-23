package com.example.meyman.domain.utils.models

import com.example.meyman.core.Constant

data class ReviewItemModel(
    val id: Int = Constant.DEFAULT_ID,
    val comment: String,
    val formatted_date_added: String,
    val hotel: String,
    val news: Int,
    val stars: Int
)
