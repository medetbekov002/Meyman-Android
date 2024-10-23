package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.auth.VerifyDto
import com.example.meyman.domain.repositories.VerifyAccountRepository
import javax.inject.Inject

class VerifyAccountUseCase @Inject constructor(
    private val verifyAccountRepository: VerifyAccountRepository
) {
    operator fun invoke(verifyDto: VerifyDto) =
        verifyAccountRepository.fetchVerifyAccount(verifyDto)
}