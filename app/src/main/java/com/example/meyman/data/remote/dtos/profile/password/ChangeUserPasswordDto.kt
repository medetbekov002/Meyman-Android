package com.example.meyman.data.remote.dtos.profile.password

import com.google.gson.annotations.SerializedName

data class ChangeUserPasswordDto(
    @SerializedName("old_password")
    val oldPassword: String,
    @SerializedName("new_password")
    val newPassword: String,
)
