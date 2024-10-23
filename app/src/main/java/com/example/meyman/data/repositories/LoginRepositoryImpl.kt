package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.LoginApiService
import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.toDomain
import com.example.meyman.domain.repositories.LoginRepository
import com.example.meyman.domain.utils.models.AnswerLoginModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApiService: LoginApiService,
) : BaseRepository(), LoginRepository {
    override fun fetchLogin(loginDto: LoginDto) = doRequests{
            loginApiService.fetchLogin(loginDto).toDomain()
        }
}