package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.profile.password.ChangeUserPasswordDto
import com.example.meyman.domain.repositories.UserProfileRepository
import javax.inject.Inject

class FetchChangeUserPasswordUseCase @Inject constructor(
    private  val userProfileRepository: UserProfileRepository
) {
    operator fun invoke(token: String, changeUserPasswordDto: ChangeUserPasswordDto) = userProfileRepository.fetchChangeUserPassword(token, changeUserPasswordDto)
}