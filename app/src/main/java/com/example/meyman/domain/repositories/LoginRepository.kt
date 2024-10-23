package com.example.meyman.domain.repositories

import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.domain.utils.models.AnswerLoginModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun fetchLogin(loginDto: LoginDto): Flow<Resource<AnswerLoginModel>>
}