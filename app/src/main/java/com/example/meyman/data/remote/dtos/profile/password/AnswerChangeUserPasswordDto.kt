package com.example.meyman.data.remote.dtos.profile.password

import com.example.meyman.domain.utils.models.profile.password.AnswerChangeUserPasswordModel
import com.google.gson.annotations.SerializedName

data class AnswerChangeUserPasswordDto(
    @SerializedName("message")
    val message: String = ""
)

fun AnswerChangeUserPasswordDto.toDomain() = AnswerChangeUserPasswordModel(
    message
)