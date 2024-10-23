package com.example.meyman.presentation.ui.screens.room_page

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchDetailRoomUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.rooms.page.RoomUI
import com.example.meyman.presentation.models.rooms.page.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.CompletableFuture
import javax.inject.Inject

@HiltViewModel
class RoomPageViewModel @Inject constructor(
    private val useCase: FetchDetailRoomUseCase
) : ViewModel() {

    private val _roomState = MutableStateFlow<UIState<RoomUI>>(UIState.Loading())
    val roomState = _roomState.asStateFlow()

    fun fetchRoom(id: Int) = viewModelScope.launch {
        useCase(id).collect {
            when (it) {
                is Either.Left -> {
                    _roomState.value = UIState.Error(it.message.toString())
                }

                is Either.Right -> {
                    it.data?.let {
                        _roomState.value = UIState.Success(it.toUI()) }
                }
            }
        }
    }
}
