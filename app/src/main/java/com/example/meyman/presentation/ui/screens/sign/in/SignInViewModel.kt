package com.example.meyman.presentation.ui.screens.sign.`in`

import androidx.lifecycle.ViewModel
import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.RegisterDto
import com.example.meyman.domain.usecases.FetchLoginUseCase
import com.example.meyman.domain.usecases.FetchRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val registerUseCase: FetchRegisterUseCase,
    private val loginUseCase: FetchLoginUseCase
) : ViewModel() {

    fun getRegisterState(registerDomain: RegisterDto) = registerUseCase(registerDomain)

    fun getLoginState(loginDto: LoginDto) = loginUseCase(loginDto)
}
