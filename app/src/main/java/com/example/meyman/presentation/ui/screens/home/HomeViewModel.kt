package com.example.meyman.presentation.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchAdvertisingUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.home.AdvertisingResultUI
import com.example.meyman.presentation.models.home.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val advertisingUseCase: FetchAdvertisingUseCase
): ViewModel() {

    private val _advertisingState = MutableStateFlow<UIState<List<AdvertisingResultUI>>>(UIState.Loading())
    val advertisingState get() = _advertisingState.asStateFlow()

    fun getAdvertising(){
        viewModelScope.launch {
            advertisingUseCase().collect{
                when(it){
                    is Either.Left -> {
                        _advertisingState.value = UIState.Error(it.message!!)
                    }
                    is Either.Right -> {
                        _advertisingState.value = UIState.Success(it.data!!.map { it.toUI() })
                    }
                }
            }
        }
    }
}