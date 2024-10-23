package com.example.meyman.domain.utils.models

import com.example.meyman.data.remote.dtos.auth.TokensDto
import com.google.gson.annotations.SerializedName

data class AnswerLoginModel(
    val tokens: TokensModel,
    val message: String = "",
)

data class TokensModel(
    val access: String = "",
    val refresh: String = ""
)
