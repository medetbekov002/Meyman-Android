package com.example.meyman.data.remote.dtos.auth

import com.example.meyman.domain.utils.models.AnswerLoginModel
import com.example.meyman.domain.utils.models.TokensModel
import com.google.gson.annotations.SerializedName

data class AnswerLoginDto(
    @SerializedName("tokens")
    val tokens: TokensDto,
    @SerializedName("message")
    val message: String = "",
)

fun AnswerLoginDto.toDomain() = AnswerLoginModel(
    tokens.toDomain(),
    message,
)

data class TokensDto(
    @SerializedName("access")
    val access: String = "",
    @SerializedName("refresh")
    val refresh: String = ""
)

fun TokensDto.toDomain() = TokensModel(
    access,
    refresh
)