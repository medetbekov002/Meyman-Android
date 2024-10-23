package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.ResetPasswordApiService
import com.example.meyman.data.remote.apiservices.VerifyApiService
import com.example.meyman.data.remote.dtos.auth.VerifyDto
import com.example.meyman.data.remote.dtos.auth.reset_password.AnswerCodeDto
import com.example.meyman.data.remote.dtos.auth.reset_password.AnswerReset
import com.example.meyman.data.remote.dtos.auth.reset_password.CodeDto
import com.example.meyman.data.remote.dtos.auth.reset_password.EmailDto
import com.example.meyman.data.remote.dtos.auth.reset_password.PasswordDto
import com.example.meyman.data.remote.dtos.auth.toDomain
import com.example.meyman.domain.repositories.ResetPasswordRepository
import com.example.meyman.domain.repositories.VerifyAccountRepository
import com.example.meyman.domain.utils.models.AnswerVerifyDomain
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ResetPasswordRepositoryImpl @Inject constructor(
    private val resetPasswordApiService: ResetPasswordApiService,
) : BaseRepository(), ResetPasswordRepository {
    override fun fetchEmail(emailDto: EmailDto) = doRequests{
            resetPasswordApiService.fetchEmail(emailDto)
        }

    override fun fetchCode(codeDto: CodeDto) = doRequests{
        resetPasswordApiService.fetchCode(codeDto)
    }

    override fun fetchResetPassword(code: String,passwordDto: PasswordDto) = doRequests{
        resetPasswordApiService.fetchResetPassword(code ,passwordDto)
    }
}