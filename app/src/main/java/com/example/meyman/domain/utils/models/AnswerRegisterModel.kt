package com.example.meyman.domain.utils.models

import com.google.gson.annotations.SerializedName

data class AnswerRegisterModel(
    val email: String ?= "",
    val username: String ?= "",
    val userType: String ?= "",
//    val password: String ?= ""
)