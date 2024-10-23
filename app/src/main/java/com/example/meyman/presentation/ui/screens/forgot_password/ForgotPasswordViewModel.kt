package com.example.meyman.presentation.ui.screens.forgot_password

import androidx.lifecycle.ViewModel
import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.RegisterDto
import com.example.meyman.data.remote.dtos.auth.reset_password.EmailDto
import com.example.meyman.domain.usecases.FetchLoginUseCase
import com.example.meyman.domain.usecases.FetchRegisterUseCase
import com.example.meyman.domain.usecases.FetchResetPasswordEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val fetchResetPasswordEmailUseCase: FetchResetPasswordEmailUseCase,
) : ViewModel() {

    fun getEmail(emailDto: EmailDto) = fetchResetPasswordEmailUseCase(emailDto)
}