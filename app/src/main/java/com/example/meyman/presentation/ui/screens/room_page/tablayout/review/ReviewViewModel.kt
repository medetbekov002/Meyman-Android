package com.example.meyman.presentation.ui.screens.room_page.tablayout.review

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.review.ResultsReviewItemUI
import com.example.meyman.presentation.models.review.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor(
) : ViewModel() {
}