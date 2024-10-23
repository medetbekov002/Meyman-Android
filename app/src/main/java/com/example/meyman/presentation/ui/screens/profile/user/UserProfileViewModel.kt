package com.example.meyman.presentation.ui.screens.profile.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchUserProfileUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.profile.ChangeUserProfileUI
import com.example.meyman.presentation.models.profile.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val useCase: FetchUserProfileUseCase
) : ViewModel() {

    private val _userProfileState = MutableStateFlow<UIState<ChangeUserProfileUI>>(UIState.Loading())
    val userProfileState = _userProfileState.asStateFlow()

    fun fetchUserProfile(token: String) = viewModelScope.launch {
        useCase(token).collect {
            when (it) {
                is Either.Left -> {
                    _userProfileState.value = UIState.Error(it.message.toString())
                }

                is Either.Right -> {
                    it.data?.let {
                        _userProfileState.value = UIState.Success(it.toUI()) }
                }
            }
        }
    }
}