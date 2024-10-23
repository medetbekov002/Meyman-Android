package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.auth.reset_password.AnswerCodeDto
import com.example.meyman.data.remote.dtos.auth.reset_password.AnswerReset
import com.example.meyman.data.remote.dtos.auth.reset_password.CodeDto
import com.example.meyman.data.remote.dtos.auth.reset_password.EmailDto
import com.example.meyman.data.remote.dtos.auth.reset_password.PasswordDto
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ResetPasswordApiService {

    @POST("api/users/reset-password-email/")
    suspend fun fetchEmail(@Body emailDto: EmailDto ): AnswerReset

    @POST("api/users/reset-password-code/")
    suspend fun fetchCode(@Body codeDto: CodeDto): AnswerCodeDto

    @POST("api/users/reset-new-password/{code}/")
    suspend fun fetchResetPassword(
        @Path("code") code: String,
        @Body passwordDto: PasswordDto): AnswerReset
}