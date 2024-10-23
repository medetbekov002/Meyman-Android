package com.example.meyman.presentation.ui.screens.sign.`in`.verifyAccount

import androidx.lifecycle.ViewModel
import com.example.meyman.data.remote.dtos.auth.VerifyDto
import com.example.meyman.domain.usecases.VerifyAccountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VerifyAccountViewModel @Inject constructor(private val verifyAccountUseCase : VerifyAccountUseCase) : ViewModel() {

    fun getVerifyState(verifyDto: VerifyDto) = verifyAccountUseCase(verifyDto)
}
