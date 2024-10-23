package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.VerifyApiService
import com.example.meyman.data.remote.dtos.auth.VerifyDto
import com.example.meyman.data.remote.dtos.auth.toDomain
import com.example.meyman.domain.repositories.VerifyAccountRepository
import com.example.meyman.domain.utils.models.AnswerVerifyDomain
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VerifyAccountRepositoryImpl @Inject constructor(
    private val registerApiService: VerifyApiService,
) : BaseRepository(), VerifyAccountRepository {

    override fun fetchVerifyAccount(verifyDto: VerifyDto) = doRequests{
            registerApiService.fetchVerifyAccount(verifyDto).toDomain()
        }
}