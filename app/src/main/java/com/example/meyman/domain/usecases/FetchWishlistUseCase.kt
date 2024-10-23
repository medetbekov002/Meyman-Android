package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.WishlistRepository
import javax.inject.Inject

class FetchWishlistUseCase  @Inject constructor(
    private val wishlistRepository: WishlistRepository
){
    operator fun invoke(token: String) = wishlistRepository.fetchWishlist(token)
}