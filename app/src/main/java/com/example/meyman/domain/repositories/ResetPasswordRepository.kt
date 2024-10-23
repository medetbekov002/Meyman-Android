package com.example.meyman.domain.repositories

import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.reset_password.AnswerCodeDto
import com.example.meyman.data.remote.dtos.auth.reset_password.AnswerReset
import com.example.meyman.data.remote.dtos.auth.reset_password.CodeDto
import com.example.meyman.data.remote.dtos.auth.reset_password.EmailDto
import com.example.meyman.data.remote.dtos.auth.reset_password.PasswordDto
import com.example.meyman.domain.utils.models.AnswerLoginModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow

interface ResetPasswordRepository {
    fun fetchEmail(emailDto: EmailDto): Flow<Resource<AnswerReset>>

    fun fetchCode(codeDto: CodeDto): Flow<Resource<AnswerCodeDto>>

    fun fetchResetPassword(code: String, passwordDto: PasswordDto): Flow<Resource<AnswerReset>>
}