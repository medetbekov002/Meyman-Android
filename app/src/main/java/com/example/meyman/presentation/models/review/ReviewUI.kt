package com.example.meyman.presentation.models.review

import com.example.meyman.domain.utils.models.review.ReviewModel
import com.google.gson.annotations.SerializedName

data class ReviewUI(
    @SerializedName("next")
    val next: Int = 0,
    @SerializedName("previous")
    val previous: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<ResultsReviewItemUI>?
)

fun ReviewModel.toUI() = ReviewUI(
    next,
    previous,
    count,
    results?.map { it.toUI() }
)