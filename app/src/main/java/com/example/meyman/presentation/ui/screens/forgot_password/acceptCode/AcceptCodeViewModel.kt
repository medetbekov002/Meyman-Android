package com.example.meyman.presentation.ui.screens.forgot_password.acceptCode

import androidx.lifecycle.ViewModel
import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.RegisterDto
import com.example.meyman.data.remote.dtos.auth.reset_password.CodeDto
import com.example.meyman.domain.usecases.FetchLoginUseCase
import com.example.meyman.domain.usecases.FetchRegisterUseCase
import com.example.meyman.domain.usecases.FetchResetPasswordCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AcceptCodeViewModel @Inject constructor(
    private val fetchResetPasswordCodeUseCase: FetchResetPasswordCodeUseCase,
) : ViewModel() {

    suspend fun getCode(codeDto: CodeDto) = fetchResetPasswordCodeUseCase(codeDto)
}