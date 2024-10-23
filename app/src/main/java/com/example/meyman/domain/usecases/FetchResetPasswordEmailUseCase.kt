package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.reset_password.EmailDto
import com.example.meyman.domain.repositories.LoginRepository
import com.example.meyman.domain.repositories.ResetPasswordRepository
import javax.inject.Inject

class FetchResetPasswordEmailUseCase @Inject constructor(
    private  val resetPasswordRepository: ResetPasswordRepository
) {
    operator fun invoke(emailDto: EmailDto) = resetPasswordRepository.fetchEmail(emailDto)
}