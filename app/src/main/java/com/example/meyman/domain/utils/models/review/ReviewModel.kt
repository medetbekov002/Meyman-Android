package com.example.meyman.domain.utils.models.review


data class ReviewModel(
    val next: Int = 0,
    val previous: Int = 0,
    val count: Int = 0,
    val results: List<ResultsReviewItemModel>?
)