package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.HotelApiService
import com.example.meyman.data.remote.dtos.hotels.toDomain
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.HotelRepository
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val hotelApiService: HotelApiService
) : BaseRepository(), HotelRepository {

    override fun fetchHotel() = doRequest {
        hotelApiService.getHotelResult().results?.map { it.toDomain() }
    }

    override fun getHotelById(id: Int) = doRequest {
        hotelApiService.getHotelById(id).toDomain()
    }

}