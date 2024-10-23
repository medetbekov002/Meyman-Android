package com.example.meyman.domain.repositories

import com.example.meyman.data.remote.dtos.hotels.ResultsHotelItemDto
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.HotelsResultDomain
import com.example.meyman.domain.utils.models.hotels.HotelsModel
import com.example.meyman.domain.utils.models.hotels.ResultsHotelItemModel
import kotlinx.coroutines.flow.Flow

interface HotelRepository {

     fun fetchHotel(): Flow<Either<String, List<ResultsHotelItemModel>?>>

     fun getHotelById(id: Int): Flow<Either<String, ResultsHotelItemModel>>
}