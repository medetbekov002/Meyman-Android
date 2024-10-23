package com.example.meyman.presentation.ui.screens.forgot_password.updatePassword

import androidx.lifecycle.ViewModel
import com.example.meyman.data.remote.dtos.auth.reset_password.CodeDto
import com.example.meyman.data.remote.dtos.auth.reset_password.PasswordDto
import com.example.meyman.domain.usecases.FetchResetPasswordCodeUseCase
import com.example.meyman.domain.usecases.FetchResetPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpdatePasswordViewModel @Inject constructor(
    private val fetchResetPasswordUseCase: FetchResetPasswordUseCase,
) : ViewModel() {

     fun getPassword(code: String, passwordDto: PasswordDto) = fetchResetPasswordUseCase(code,passwordDto)
}