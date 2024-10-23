package com.example.meyman.data.remote.dtos.favorite.wishlist

import com.example.meyman.domain.utils.models.favorite.wishlist.AnswerWishlistModel
import com.google.gson.annotations.SerializedName

data class AnswerWishlistDto(
    @SerializedName("favorite_count")
    val favoriteCount: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("user")
    val user: Int = 0
)

fun AnswerWishlistDto.toDomain() = AnswerWishlistModel(
    favoriteCount,
    id,
    title,
    user
)