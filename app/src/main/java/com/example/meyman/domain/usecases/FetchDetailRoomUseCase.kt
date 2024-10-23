package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.RoomsRepository
import javax.inject.Inject

class FetchDetailRoomUseCase @Inject constructor(
    private val repository: RoomsRepository
) {

    operator fun invoke(id: Int) = repository.fetchDetailRooms(id)
}