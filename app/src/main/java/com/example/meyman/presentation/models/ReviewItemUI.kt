package com.example.meyman.presentation.models

import android.os.Parcelable
import com.example.meyman.domain.utils.models.ReviewItemModel
import kotlinx.parcelize.Parcelize


@Parcelize
data class ReviewItemUI(
    val comment: Int,
    val formatted_date_added: String,
    val hotel: String,
    val id: String,
    val news: Int,
    val stars: Int
) : Parcelable

fun ReviewItemModel.toUI(): ReviewItemUI {
    return ReviewItemUI(
        id,
        comment,
        formatted_date_added,
        hotel,
        news,
        stars
    )
}