package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.auth.AnswerVerifyDto
import com.example.meyman.data.remote.dtos.auth.VerifyDto
import retrofit2.http.Body
import retrofit2.http.POST

interface VerifyApiService {

    @POST("api/users/verify/")
    suspend fun fetchVerifyAccount(@Body verifyDto: VerifyDto): AnswerVerifyDto
}