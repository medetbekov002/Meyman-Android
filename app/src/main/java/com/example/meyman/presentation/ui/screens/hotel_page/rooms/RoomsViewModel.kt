package com.example.meyman.presentation.ui.screens.hotel_page.rooms

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchRoomsUseCase
import com.example.meyman.presentation.models.rooms.list.ResultsRoomsListItemUI
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.hotels.ResultsHotelItemUI
import com.example.meyman.presentation.models.hotels.toUI
import com.example.meyman.presentation.models.rooms.list.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val roomsUseCase: FetchRoomsUseCase
): ViewModel() {

    private val _roomsState = MutableStateFlow<UIState<ResultsHotelItemUI>>(UIState.Loading())
    val roomsState get() = _roomsState.asStateFlow()

    fun getChooseRoomState(id: Int){
        viewModelScope.launch {
            roomsUseCase(id).collect{
                when(it){
                    is Either.Left -> {
                        _roomsState.value = UIState.Error(it.message!!)
                        Log.e("ololo", "getChooseRoomState: ${it.message}", )
                    }
                    is Either.Right -> {
                        _roomsState.value = UIState.Success(it.data!!.toUI())
                    }
                }
            }
        }
    }
}