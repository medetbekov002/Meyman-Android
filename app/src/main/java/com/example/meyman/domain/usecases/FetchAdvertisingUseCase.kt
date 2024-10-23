package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.AdvertisingRepository
import javax.inject.Inject

class FetchAdvertisingUseCase  @Inject constructor(
    private val advertisingRepository: AdvertisingRepository
){
     operator fun invoke() = advertisingRepository.getAdvertisingRepository()
}