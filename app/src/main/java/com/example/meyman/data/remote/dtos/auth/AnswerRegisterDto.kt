package com.example.meyman.data.remote.dtos.auth

import com.example.meyman.domain.utils.models.AnswerRegisterModel
import com.google.gson.annotations.SerializedName

data class AnswerRegisterDto(
    @SerializedName("email")
    val email: String ?= "",
    @SerializedName("username")
    val username: String ?= "",
    @SerializedName("user_type")
    val userType: String ?= "",
//    @SerializedName("password")
//    val password: String ?= ""
)

fun AnswerRegisterDto.toDomain() = AnswerRegisterModel(
    email = email, username =  username, userType = userType,
//    password = password
)