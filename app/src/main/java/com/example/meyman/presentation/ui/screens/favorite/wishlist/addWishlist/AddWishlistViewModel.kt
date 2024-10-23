package com.example.meyman.presentation.ui.screens.favorite.wishlist.addWishlist

import androidx.lifecycle.ViewModel
import com.example.meyman.data.remote.dtos.favorite.wishlist.WishlistDto
import com.example.meyman.domain.usecases.FetchAddWishlistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddWishlistViewModel @Inject constructor(private val addWishlistUseCase: FetchAddWishlistUseCase) : ViewModel() {

    fun fetchAddWishlist(token: String, wishlistDto: WishlistDto) = addWishlistUseCase(token, wishlistDto)
}
