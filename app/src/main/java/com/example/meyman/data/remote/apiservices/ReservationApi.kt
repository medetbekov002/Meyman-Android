package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.reservation.ReservationGetDto
import com.example.meyman.data.remote.dtos.reservation.ReservationResultDto
import com.example.meyman.domain.utils.models.reservation.ReservationPostModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ReservationApi {

    @GET("api/housing/housing_reservations/")
    suspend fun getReservation(
        @Header("Authorization") token: String
    ): List<ReservationResultDto>

    @POST("api/housing/housing_reservations/")
    suspend fun postReservation(
        @Header("Authorization") token: String,
        @Body reservationPostModel: ReservationPostModel
    ): ReservationGetDto

}