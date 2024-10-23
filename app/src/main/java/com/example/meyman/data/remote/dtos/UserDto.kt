package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.UserModel
import com.example.meyman.domain.utils.models.UsernameModel

data class UserDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<UsernameDto>
)

fun UserDto<UsernameDto>.toDomain() = UserModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)

data class UsernameDto(
    val avatar: String,
    val date_joined: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)

fun UsernameDto.toDomain() = UsernameModel(
    id,
    avatar,
    date_joined,
    email,
    first_name,
    last_name
)