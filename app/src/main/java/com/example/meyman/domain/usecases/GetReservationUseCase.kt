package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ReservationRepo
import com.example.meyman.domain.repositories.UserProfileRepository
import javax.inject.Inject

class GetReservationUseCase @Inject constructor(
    private val repo: ReservationRepo
) {
    fun getReservation(token: String) = repo.getReservation(token)
}