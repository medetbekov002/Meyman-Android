//package com.example.meyman.presentation.ui.screens.booking.booking_detail
//
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.meyman.domain.usecases.BookingDetailsUseCase
//import com.example.meyman.domain.utils.Either
//import com.example.meyman.presentation.models.BookingUI
//import com.example.meyman.presentation.models.toUI
//import com.example.meyman.presentation.state.UIState
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class BookingDetailViewModel @Inject constructor(
//    private val bookingDetailsUseCase: BookingDetailsUseCase
//) : ViewModel() {
//
//    private val _bookingDetailValue = MutableStateFlow<UIState<BookingUI>>(UIState.Loading())
//    val bookingDetail = _bookingDetailValue.asStateFlow()
//
//    fun getBookingById(id: Int) = viewModelScope.launch {
//        bookingDetailsUseCase(id).collect {
//            when (it) {
//                is Either.Left -> {
//                    _bookingDetailValue.value = UIState.Error(it.message.toString())
//                    Log.e("ololo", "BookingDetailViewModel-left: $it")
//                }
//
//                is Either.Right -> {
//                    it.data?.let {
//                        _bookingDetailValue.value = UIState.Success(it.toUI())
//                    }
//                    Log.e("ololo", "BookingDetailViewModel-right: $it")
//                }
//            }
//        }
//    }
//}