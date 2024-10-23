package com.example.meyman.presentation.ui.screens.profile.user.change

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.data.remote.dtos.profile.password.ChangeUserPasswordDto
import com.example.meyman.domain.usecases.FetchChangeUserPasswordUseCase
import com.example.meyman.domain.usecases.FetchChangeUserProfileUseCase
import com.example.meyman.domain.usecases.FetchUserProfileUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.profile.ChangeUserProfileUI
import com.example.meyman.presentation.models.profile.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

@HiltViewModel
class ChangeUserProfileViewModel @Inject constructor(
    private val changeUserProfileUseCase: FetchChangeUserProfileUseCase,
    private val userProfileUseCase: FetchUserProfileUseCase,
    private val changeUserPasswordUseCase: FetchChangeUserPasswordUseCase,
) : ViewModel() {

    private val _userProfileState =
        MutableStateFlow<UIState<ChangeUserProfileUI>>(UIState.Loading())

    private val _changeUserProfileState =
        MutableStateFlow<UIState<ChangeUserProfileUI>>(UIState.Loading())

    val changeUserProfileState = _changeUserProfileState.asStateFlow()

    val userProfileState = _userProfileState.asStateFlow()

    fun fetchChangeUserProfile(
        token: String,
        image: MultipartBody.Part?,
        username: RequestBody,
        phoneNumber: RequestBody
    ) = viewModelScope.launch {
        changeUserProfileUseCase(
            token,
            image,
            username, phoneNumber
        ).collect {
            when (it) {
                is Either.Left -> {
                    _changeUserProfileState.value = UIState.Error(it.message.toString())
                }

                is Either.Right -> {
                    it.data?.let {
                        _changeUserProfileState.value = UIState.Success(it.toUI())
                    }
                }
            }
        }
    }

    fun fetchUserProfile(token: String) = viewModelScope.launch {
        userProfileUseCase(token).collect {
            when (it) {
                is Either.Left -> {
                    _userProfileState.value = UIState.Error(it.message.toString())
                }

                is Either.Right -> {
                    it.data?.let {
                        _userProfileState.value = UIState.Success(it.toUI())
                    }
                }
            }
        }
    }

    fun fetchChangeUserPassword(token: String, changeUserPasswordDto: ChangeUserPasswordDto) = changeUserPasswordUseCase(token, changeUserPasswordDto)

}