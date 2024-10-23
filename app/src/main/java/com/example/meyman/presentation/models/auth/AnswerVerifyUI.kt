package com.example.meyman.presentation.models.auth

import com.example.meyman.domain.utils.models.AnswerVerifyDomain
import com.google.gson.annotations.SerializedName

data class AnswerVerifyUI(
    @SerializedName("message")
    val message: String,
)

fun AnswerVerifyDomain.toUI() = AnswerVerifyUI(
    message
)