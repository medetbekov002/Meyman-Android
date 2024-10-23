package com.example.meyman.data.remote.dtos.auth.token

import com.example.meyman.domain.utils.models.auth.token.AnswerAccessTokenModel
import com.google.gson.annotations.SerializedName

data class AnswerAccessTokenDto(
    @SerializedName("access")
    val access: String
)

fun AnswerAccessTokenDto.toDomain() = AnswerAccessTokenModel(
    access
)
