package com.example.meyman.data.remote.dtos.auth

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("password")
    val password: String,
    @SerializedName("email")
    val email: String
)