package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.HotelRepository
import javax.inject.Inject

class FetchDetailHotelUseCase @Inject constructor(
    private val hotelRepository: HotelRepository
) {
     operator fun invoke(id: Int) = hotelRepository.getHotelById(id)
}