package com.example.meyman.data.remote.dtos.auth.reset_password

import com.google.gson.annotations.SerializedName

data class PasswordDto(
@SerializedName("password")
    val password: String
)
