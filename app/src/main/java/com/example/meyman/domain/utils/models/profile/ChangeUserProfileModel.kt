package com.example.meyman.domain.utils.models.profile

data class ChangeUserProfileModel(
    val image: String ?= "",
    val userType: String = "",
    val phoneNumber: String ?= "",
    val id: Int = 0,
    val email: String = "",
    val username: String = ""
)