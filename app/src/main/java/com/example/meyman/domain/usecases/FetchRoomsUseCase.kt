package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.HotelRepository
import com.example.meyman.domain.repositories.RoomsRepository
import javax.inject.Inject

class FetchRoomsUseCase @Inject constructor(
    private val roomsRepository: RoomsRepository
) {
    operator fun invoke(id: Int) = roomsRepository.fetchRooms(id)
}