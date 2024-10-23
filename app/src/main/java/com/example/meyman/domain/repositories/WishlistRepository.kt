package com.example.meyman.domain.repositories

import com.example.meyman.data.remote.dtos.favorite.wishlist.AnswerWishlistDto
import com.example.meyman.data.remote.dtos.favorite.wishlist.WishlistDto
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.favorite.wishlist.AnswerWishlistModel
import com.example.meyman.domain.utils.models.hotels.ResultsHotelItemModel
import com.example.meyman.domain.utils.models.profile.ChangeUserProfileModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface WishlistRepository {

    fun fetchWishlist(token: String): Flow<Either<String, List<AnswerWishlistModel>>>

    fun fetchAddWishlist(
        token: String,
        wishlistDto: WishlistDto
    ): Flow<Resource<AnswerWishlistModel?>>

     suspend fun fetchDeleteWishlist(token: String, id: Int)
}