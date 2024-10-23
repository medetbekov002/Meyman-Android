package com.example.meyman.data.remote.dtos.review

import com.example.meyman.domain.utils.models.review.ResultsReviewItemModel
import com.google.gson.annotations.SerializedName

data class ResultsReviewItemDto(@SerializedName("food_rating")
                       val foodRating: Int = 0,
                                @SerializedName("date_added")
                       val dateAdded: String = "",
                                @SerializedName("cleanliness_rating")
                       val cleanlinessRating: Int = 0,
                                @SerializedName("housing")
                       val housing: Int = 0,
                                @SerializedName("comfort_rating")
                       val comfortRating: Int = 0,
                                @SerializedName("value_for_money_rating")
                       val valueForMoneyRating: Int = 0,
                                @SerializedName("comment")
                       val comment: String = "",
                                @SerializedName("user")
                       val user: Int = 0,
                                @SerializedName("location_rating")
                       val locationRating: Int = 0,
                                @SerializedName("staff_rating")
                       val staffRating: Int = 0)

fun ResultsReviewItemDto.toDomain() = ResultsReviewItemModel(
    foodRating,
    dateAdded,
    cleanlinessRating,
    housing,
    comfortRating,
    valueForMoneyRating,
    comment,
    user,
    locationRating,
    staffRating
)