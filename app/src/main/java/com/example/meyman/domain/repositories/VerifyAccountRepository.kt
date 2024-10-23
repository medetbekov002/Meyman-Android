package com.example.meyman.domain.repositories

import com.example.meyman.data.remote.dtos.auth.VerifyDto
import com.example.meyman.domain.utils.models.AnswerVerifyDomain
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow

interface VerifyAccountRepository {
    fun fetchVerifyAccount(verifyDto: VerifyDto): Flow<Resource<AnswerVerifyDomain>>
}