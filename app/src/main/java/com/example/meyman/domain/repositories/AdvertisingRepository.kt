package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.home.AdvertisingResultModel
import kotlinx.coroutines.flow.Flow

interface AdvertisingRepository {

     fun getAdvertisingRepository(): Flow<Either<String, List<AdvertisingResultModel>>>
}