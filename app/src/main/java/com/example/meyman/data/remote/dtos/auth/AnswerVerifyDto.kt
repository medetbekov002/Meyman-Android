package com.example.meyman.data.remote.dtos.auth

import com.example.meyman.domain.utils.models.AnswerVerifyDomain
import com.google.gson.annotations.SerializedName

data class AnswerVerifyDto(
    @SerializedName("message")
    val message: String,
)

fun AnswerVerifyDto.toDomain() = AnswerVerifyDomain(
    message
)