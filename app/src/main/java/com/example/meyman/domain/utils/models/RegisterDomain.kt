package com.example.meyman.domain.utils.models

import com.google.gson.annotations.SerializedName

data class RegisterDomain(
    val password: String?,
    val userType: String?,
    val email: String?,
    val username: String?)
