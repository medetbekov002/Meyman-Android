package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.favorite.wishlist.WishlistDto
import com.example.meyman.domain.repositories.WishlistRepository
import javax.inject.Inject

class FetchAddWishlistUseCase @Inject constructor(
    private  val wishlistRepository: WishlistRepository
) {
    operator fun invoke(token: String,wishlistDto: WishlistDto) = wishlistRepository.fetchAddWishlist(token, wishlistDto)
}