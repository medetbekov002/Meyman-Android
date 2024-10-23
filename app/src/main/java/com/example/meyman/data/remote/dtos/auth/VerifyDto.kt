package com.example.meyman.data.remote.dtos.auth

import com.google.gson.annotations.SerializedName

data class VerifyDto(
    @SerializedName("verify_code")
    val verifyCode: String ?= "",
    @SerializedName("email")
    val email: String
)