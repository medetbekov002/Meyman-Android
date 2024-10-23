package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.home.AdvertisingResultDto
import retrofit2.Response
import retrofit2.http.GET

interface AdvertisingApiService {

    @GET("api/advertising/advertising/")
    suspend fun fetchAdvertising(): List<AdvertisingResultDto>
}