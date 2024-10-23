package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.TokenApiService
import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.toDomain
import com.example.meyman.data.remote.dtos.auth.token.RefreshTokenDto
import com.example.meyman.data.remote.dtos.auth.token.toDomain
import com.example.meyman.domain.repositories.TokenRepository
import com.example.meyman.domain.utils.models.auth.token.AnswerAccessTokenModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenApiService: TokenApiService,
) : BaseRepository(), TokenRepository {

    override fun fetchToken(tokenDto: RefreshTokenDto) = doRequests{
            tokenApiService.fetchToken(tokenDto).toDomain()
        }
}