package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.hotels.ResultsHotelItemDto
import com.example.meyman.data.remote.dtos.rooms.page.RoomDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RoomsApiService {

    @GET("api/housing/housing/{id}/")
    suspend fun fetchRooms(
        @Path("id") id: Int
    ): ResultsHotelItemDto

    @GET("api/housing/rooms/{id}/")
    suspend fun fetchDetailRoom(
        @Path("id") id: Int
    ): Response<RoomDto>
}