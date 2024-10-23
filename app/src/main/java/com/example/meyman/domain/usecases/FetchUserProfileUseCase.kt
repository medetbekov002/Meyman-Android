package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.UserProfileRepository
import okhttp3.RequestBody
import javax.inject.Inject

class FetchUserProfileUseCase @Inject constructor(
    private val userProfileRepository: UserProfileRepository
) {
    operator fun invoke(token: String) = userProfileRepository.fetchUserProfile(token)
}