package com.example.meyman.presentation.ui.screens.favorite.wishlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.data.remote.dtos.auth.reset_password.PasswordDto
import com.example.meyman.domain.usecases.FetchDeleteWishlistUseCase
import com.example.meyman.domain.usecases.FetchWishlistUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.favorite.wishlist.AnswerWishlistUI
import com.example.meyman.presentation.models.favorite.wishlist.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val wishlistUseCase: FetchWishlistUseCase,
    private val deleteWishlistUseCase: FetchDeleteWishlistUseCase
): ViewModel() {

    private val _wishlistState = MutableStateFlow<UIState<List<AnswerWishlistUI>>>(UIState.Loading())
    val wishlistState get() = _wishlistState.asStateFlow()

    fun getWishlist(token: String){
        viewModelScope.launch {
            wishlistUseCase(token).collect{
                when(it){
                    is Either.Left -> {
                        _wishlistState.value = UIState.Error(it.message!!)
                        Log.e("ololoLeft", "getChooseRoomState: ${it.message}", )
                    }
                    is Either.Right -> {
                        _wishlistState.value = UIState.Success(it.data!!.map { it.toUI() })
                        Log.e("ololoSucces", "getChooseRoomState: ${it.data}", )
                    }

                    else -> {}
                }
            }
        }
    }

    suspend fun deleteWishlist(token: String, id : Int) = deleteWishlistUseCase.invoke(token, id)

}