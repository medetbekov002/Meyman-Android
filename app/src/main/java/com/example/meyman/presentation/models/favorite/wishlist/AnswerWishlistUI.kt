package com.example.meyman.presentation.models.favorite.wishlist

import com.example.meyman.domain.utils.models.favorite.wishlist.AnswerWishlistModel
import com.google.gson.annotations.SerializedName

data class AnswerWishlistUI(
    @SerializedName("favorite_count")
    val favoriteCount: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("user")
    val user: Int = 0
)

fun AnswerWishlistModel.toUI() = AnswerWishlistUI(
    favoriteCount,
    id,
    title,
    user
)
