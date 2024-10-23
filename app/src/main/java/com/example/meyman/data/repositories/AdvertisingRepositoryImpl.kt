package com.example.meyman.data.repositories

import android.util.Log
import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.AdvertisingApiService
import com.example.meyman.data.remote.dtos.home.toDomain
import com.example.meyman.domain.repositories.AdvertisingRepository
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.home.AdvertisingResultModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AdvertisingRepositoryImpl @Inject constructor(
    private val advertisingApiService: AdvertisingApiService
) : BaseRepository(), AdvertisingRepository {

    override fun getAdvertisingRepository() = doRequest {
        Log.e("homka", "getAdvertisingRepository: + ${advertisingApiService.fetchAdvertising()}")
        advertisingApiService.fetchAdvertising().map { it.toDomain() }
    }
}