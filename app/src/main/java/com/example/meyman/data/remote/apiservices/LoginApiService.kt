package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.auth.AnswerLoginDto
import com.example.meyman.data.remote.dtos.auth.LoginDto
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {

    @POST("api/users/login/")
    suspend fun fetchLogin(@Body loginDto: LoginDto): AnswerLoginDto
}