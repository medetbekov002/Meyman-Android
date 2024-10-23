package com.example.meyman.data.remote.dtos.auth.token

import com.google.gson.annotations.SerializedName

data class RefreshTokenDto(
    @SerializedName("refresh")
    val refresh: String,
)
