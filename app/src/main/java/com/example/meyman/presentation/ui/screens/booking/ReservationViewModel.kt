package com.example.meyman.presentation.ui.screens.booking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.GetReservationUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.auth.toUI
import com.example.meyman.presentation.models.reservation.ReservationResultUI
import com.example.meyman.presentation.models.reservation.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReservationViewModel @Inject constructor(
    private val useCase: GetReservationUseCase
) : ViewModel() {

    private val _reservation = MutableStateFlow<UIState<List<ReservationResultUI>>>(UIState.Loading())
    val reservation = _reservation.asStateFlow()

    fun getReservation(token: String) = viewModelScope.launch {
        useCase.getReservation(token).collect {
            when (it) {
                is Either.Left -> {
                    _reservation.value = UIState.Error(it.message.toString())
                }

                is Either.Right -> {
                    it.data?.let {
                        _reservation.value = UIState.Success(it.map { it.toUI() })
                    }
                }
            }
        }
    }

}