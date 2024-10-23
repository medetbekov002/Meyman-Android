package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.domain.repositories.LoginRepository
import javax.inject.Inject

class FetchLoginUseCase @Inject constructor(
    private  val loginRepository: LoginRepository
) {
    operator fun invoke(loginDto: LoginDto) = loginRepository.fetchLogin(loginDto)
}