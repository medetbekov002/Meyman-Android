package com.example.meyman.presentation.models.auth

import com.example.meyman.domain.utils.models.AnswerLoginModel
import com.example.meyman.domain.utils.models.TokensModel
import com.google.gson.annotations.SerializedName

data class AnswerLoginUI(
    @SerializedName("tokens")
    val tokens: TokensUI,
    @SerializedName("message")
    val message: String = "",
)

fun AnswerLoginModel.toUI() = AnswerLoginUI(
    tokens.toUI(),
    message,
)

data class TokensUI(
    @SerializedName("access")
    val access: String = "",
    @SerializedName("refresh")
    val refresh: String = ""
)

fun TokensModel.toUI() = TokensUI(
    access,
    refresh
)