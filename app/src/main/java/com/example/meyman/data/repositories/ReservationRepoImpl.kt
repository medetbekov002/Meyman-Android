package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.ReservationApi
import com.example.meyman.data.remote.dtos.reservation.toDomain
import com.example.meyman.domain.repositories.ReservationRepo
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.reservation.ReservationGetModel
import com.example.meyman.domain.utils.models.reservation.ReservationPostModel
import com.example.meyman.domain.utils.models.reservation.ReservationResultModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReservationRepoImpl @Inject constructor(
    private val api: ReservationApi
): ReservationRepo, BaseRepository() {

    override fun getReservation(token: String) = doRequest {
        api.getReservation(token).map { it.toDomain() }
    }

    override fun postReservation(
        token: String,
        reservationPostModel: ReservationPostModel
    ) = doRequest {
        api.postReservation(token, reservationPostModel).toDomain()
    }

}