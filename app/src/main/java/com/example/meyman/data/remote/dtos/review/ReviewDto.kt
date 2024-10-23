package com.example.meyman.data.remote.dtos.review

import com.example.meyman.domain.utils.models.review.ReviewModel
import com.google.gson.annotations.SerializedName

data class ReviewDto(@SerializedName("next")
                     val next: Int = 0,
                     @SerializedName("previous")
                     val previous: Int = 0,
                     @SerializedName("count")
                     val count: Int = 0,
                     @SerializedName("results")
                     val results: List<ResultsReviewItemDto>?)

fun ReviewDto.toDomain() = ReviewModel(
    next,
    previous,
    count,
    results?.map { it.toDomain() }
)
