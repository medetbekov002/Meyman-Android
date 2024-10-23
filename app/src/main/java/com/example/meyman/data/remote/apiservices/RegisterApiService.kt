package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.auth.AnswerRegisterDto
import com.example.meyman.data.remote.dtos.auth.RegisterDto
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApiService {

    @POST("api/users/signup/")
    suspend fun fetchRegister(@Body registerDomain: RegisterDto): AnswerRegisterDto
}