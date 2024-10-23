package com.example.meyman.data.remote.dtos.profile

import com.example.meyman.domain.utils.models.profile.UserProfileModel
import com.google.gson.annotations.SerializedName

data class UserProfileDto(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("user_type")
    val userType: String = "",
    @SerializedName("phone_number")
    val phoneNumber: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("email")
    val email: String = "",
    @SerializedName("username")
    val username: String = ""
)

fun UserProfileDto.toDomain() = UserProfileModel(
    image,
    userType,
    phoneNumber,
    id,
    email,
    username
)