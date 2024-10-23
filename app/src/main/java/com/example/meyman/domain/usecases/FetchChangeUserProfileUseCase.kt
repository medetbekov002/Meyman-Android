package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.UserProfileRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class FetchChangeUserProfileUseCase @Inject constructor(
    private val userProfileRepository: UserProfileRepository
) {
    operator fun invoke(
        token: String,
        image: MultipartBody.Part?,
        username: RequestBody,
        phoneNumber: RequestBody
    ) = userProfileRepository.fetchChangeUserProfile(token,
        image,
        username, phoneNumber)

}