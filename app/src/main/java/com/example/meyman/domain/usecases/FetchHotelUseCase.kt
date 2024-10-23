package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.HotelRepository
import javax.inject.Inject

class FetchHotelUseCase @Inject constructor(
    private  val hotelRepository: HotelRepository
) {
    operator fun invoke() = hotelRepository.fetchHotel()
}