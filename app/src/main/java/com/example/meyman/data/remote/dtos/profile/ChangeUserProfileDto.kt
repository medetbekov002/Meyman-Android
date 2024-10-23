package com.example.meyman.data.remote.dtos.profile

import com.example.meyman.domain.utils.models.profile.ChangeUserProfileModel
import com.google.gson.annotations.SerializedName

data class ChangeUserProfileDto(
    @SerializedName("image")
    val image: String ?= "",
    @SerializedName("user_type")
    val userType: String = "",
    @SerializedName("phone_number")
    val phoneNumber: String ?= "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("email")
    val email: String = "",
    @SerializedName("username")
    val username: String = ""
)

fun ChangeUserProfileDto.toDomain() = ChangeUserProfileModel(
    image,
    userType,
    phoneNumber,
    id,
    email,
    username
)