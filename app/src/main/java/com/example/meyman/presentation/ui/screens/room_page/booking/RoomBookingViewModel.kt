package com.example.meyman.presentation.ui.screens.room_page.booking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.GetReservationUseCase
import com.example.meyman.domain.usecases.PostReservationUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.reservation.ReservationPostModel
import com.example.meyman.presentation.models.reservation.ReservationGetUI
import com.example.meyman.presentation.models.reservation.ReservationResultUI
import com.example.meyman.presentation.models.reservation.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomBookingViewModel @Inject constructor(
    private val useCase: PostReservationUseCase
) : ViewModel() {
    private val _reservation = MutableStateFlow<UIState<ReservationGetUI>>(UIState.Loading())
    val reservation = _reservation.asStateFlow()

    fun postReservation(token:String, reservationPostModel: ReservationPostModel) = viewModelScope.launch {
        useCase.postReservation(token, reservationPostModel).collect {
            when (it) {
                is Either.Left -> {
                    _reservation.value = UIState.Error(it.message.toString())
                    Log.e("erbol", "getBooking-error: ${it.message.toString()}")
                }

                is Either.Right -> {
                    it.data?.let {
                        _reservation.value = UIState.Success(it.toUI())
                    }
                    Log.e("erbol", "getBooking-success: ${it.data}")
                }
            }
        }
    }
}