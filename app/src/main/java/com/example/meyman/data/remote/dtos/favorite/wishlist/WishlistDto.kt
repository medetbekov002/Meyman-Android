package com.example.meyman.data.remote.dtos.favorite.wishlist

import com.google.gson.annotations.SerializedName

data class WishlistDto(
    @SerializedName("user")
    val user: Int,
    @SerializedName("title")
    val title: String
)
