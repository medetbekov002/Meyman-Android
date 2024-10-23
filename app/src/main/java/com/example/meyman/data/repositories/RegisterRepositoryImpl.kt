package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.RegisterApiService
import com.example.meyman.data.remote.dtos.auth.RegisterDto
import com.example.meyman.data.remote.dtos.auth.toDomain
import com.example.meyman.domain.repositories.RegisterRepository
import com.example.meyman.domain.utils.models.AnswerRegisterModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(
    private val registerApiService: RegisterApiService,
) : BaseRepository(), RegisterRepository {
    override fun fetchRegister(registerDto: RegisterDto) = doRequests{
     registerApiService.fetchRegister(registerDto).toDomain()
        }
}