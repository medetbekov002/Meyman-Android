package com.example.meyman.presentation.ui.activity

import androidx.lifecycle.ViewModel
import com.example.meyman.data.remote.dtos.auth.token.RefreshTokenDto
import com.example.meyman.domain.usecases.FetchTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val tokenUseCase: FetchTokenUseCase,
) : ViewModel() {

    fun getToken(tokenDto: RefreshTokenDto) = tokenUseCase(tokenDto)
}