package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.WishlistRepository
import javax.inject.Inject

class FetchDeleteWishlistUseCase @Inject constructor(private val wishlistRepository: WishlistRepository) {

    suspend operator fun invoke(token: String, id: Int) =
        wishlistRepository.fetchDeleteWishlist(token, id)
}