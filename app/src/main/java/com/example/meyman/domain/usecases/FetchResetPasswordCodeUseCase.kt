package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.reset_password.CodeDto
import com.example.meyman.domain.repositories.LoginRepository
import com.example.meyman.domain.repositories.ResetPasswordRepository
import javax.inject.Inject

class FetchResetPasswordCodeUseCase @Inject constructor(
    private  val resetPasswordRepository: ResetPasswordRepository
) {
    operator fun invoke(codeDto: CodeDto) = resetPasswordRepository.fetchCode(codeDto)
}