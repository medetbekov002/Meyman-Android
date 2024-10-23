package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.RoomsApiService
import com.example.meyman.data.remote.apiservices.WishlistApiService
import com.example.meyman.data.remote.dtos.favorite.wishlist.WishlistDto
import com.example.meyman.data.remote.dtos.favorite.wishlist.toDomain
import com.example.meyman.data.remote.dtos.hotels.toDomain
import com.example.meyman.domain.repositories.RoomsRepository
import com.example.meyman.domain.repositories.WishlistRepository
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.favorite.wishlist.AnswerWishlistModel
import com.example.meyman.domain.utils.models.profile.ChangeUserProfileModel
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class WishlistRepositoryImpl
    @Inject constructor(
    private val service: WishlistApiService
) : BaseRepository(), WishlistRepository {

    override fun fetchWishlist(token: String) = doRequest{
        service.fetchWishlist(token).map { it.toDomain() }
    }

    override fun fetchAddWishlist(
        token: String,
        wishlistDto: WishlistDto
    ) = doRequests {
        service.fetchAddWishlist(token, wishlistDto).toDomain()
    }

    override suspend fun fetchDeleteWishlist(token: String, id: Int) {
        service.fetchDeleteWishlist(token, id)
    }

}