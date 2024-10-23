package com.example.meyman.presentation.models.profile.password

import com.example.meyman.domain.utils.models.profile.password.AnswerChangeUserPasswordModel
import com.google.gson.annotations.SerializedName

data class AnswerChangeUserPasswordUI(
    @SerializedName("message")
    val message: String = ""
)

fun AnswerChangeUserPasswordModel.toUI() = AnswerChangeUserPasswordUI(
    message
)