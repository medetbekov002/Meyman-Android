package com.example.meyman.data.remote.dtos.auth

import com.google.gson.annotations.SerializedName

data class RegisterDto(
    @SerializedName("email")
    val email: String = "",
    @SerializedName("username")
    val username: String = "",
    @SerializedName("user_type")
    val userType: String = "",
    @SerializedName("password")
    val password: String = ""
)