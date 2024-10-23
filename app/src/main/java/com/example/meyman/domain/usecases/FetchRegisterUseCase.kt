package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.auth.RegisterDto
import com.example.meyman.domain.repositories.RegisterRepository
import javax.inject.Inject

class FetchRegisterUseCase @Inject constructor(
    private  val registerRepository: RegisterRepository
) {
    operator fun invoke(registerDto: RegisterDto) = registerRepository.fetchRegister(registerDto)
}