package com.example.meyman.presentation.models.auth

import com.example.meyman.domain.utils.models.AnswerRegisterModel
import com.google.gson.annotations.SerializedName

data class AnswerRegisterUI(
    @SerializedName("email")
    val email: String ?= "",
    @SerializedName("username")
    val username: String ?= "",
    @SerializedName("user_type")
    val userType: String ?= "",
//    @SerializedName("password")
//    val password: String ?= ""
)

fun AnswerRegisterModel.toUI() = AnswerRegisterUI(
    userType = userType, email = email, username = username,
//    password = password
)