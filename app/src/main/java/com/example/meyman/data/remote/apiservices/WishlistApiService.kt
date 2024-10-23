package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.favorite.wishlist.AnswerWishlistDto
import com.example.meyman.data.remote.dtos.favorite.wishlist.WishlistDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface WishlistApiService {

    @GET("api/favorite/wishlist/")
    suspend fun fetchWishlist(
        @Header("Authorization") token: String,
        ): List<AnswerWishlistDto>

    @POST("api/favorite/wishlist/")
    suspend fun fetchAddWishlist(
        @Header("Authorization") token: String,
        @Body wishlistDto: WishlistDto
    ): AnswerWishlistDto

    @DELETE("api/favorite/wishlist/{id}")
    suspend fun fetchDeleteWishlist(
        @Header("Authorization") token: String,
        @Path("id") id: Int? = null
    ): Response<Unit>
}