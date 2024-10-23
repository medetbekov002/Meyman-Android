package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.reservation.ReservationGetModel
import com.example.meyman.domain.utils.models.reservation.ReservationPostModel
import com.example.meyman.domain.utils.models.reservation.ReservationResultModel
import kotlinx.coroutines.flow.Flow

interface ReservationRepo {

    fun getReservation(token: String): Flow<Either<String, List<ReservationResultModel>>>

     fun postReservation(
        token: String,
        reservationPostModel: ReservationPostModel
    ): Flow<Either<String, ReservationGetModel>>
}