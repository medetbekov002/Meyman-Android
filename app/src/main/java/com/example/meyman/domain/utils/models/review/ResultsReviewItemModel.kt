package com.example.meyman.domain.utils.models.review


data class ResultsReviewItemModel(
    val foodRating: Int = 0,
    val dateAdded: String = "",
    val cleanlinessRating: Int = 0,
    val housing: Int = 0,
    val comfortRating: Int = 0,
    val valueForMoneyRating: Int = 0,
    val comment: String = "",
    val user: Int = 0,
    val locationRating: Int = 0,
    val staffRating: Int = 0
)