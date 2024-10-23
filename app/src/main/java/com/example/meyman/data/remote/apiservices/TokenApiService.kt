package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.auth.token.AnswerAccessTokenDto
import com.example.meyman.data.remote.dtos.auth.token.RefreshTokenDto
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface TokenApiService {

    @POST("api/users/refresh/")
    suspend fun fetchToken(
        @Body refreshTokenDto: RefreshTokenDto): AnswerAccessTokenDto
}