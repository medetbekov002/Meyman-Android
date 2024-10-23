package com.example.meyman.domain.utils.models

import com.example.meyman.core.Constant

data class UserModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<UsernameModel>
)

data class UsernameModel(
    val id: Int = Constant.DEFAULT_ID,
    val avatar: String,
    val date_joined: String,
    val email: String,
    val first_name: String,
    val last_name: String
)
