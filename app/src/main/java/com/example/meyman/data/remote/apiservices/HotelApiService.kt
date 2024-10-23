package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.HotelsResult
import com.example.meyman.data.remote.dtos.hotels.HotelsDto
import com.example.meyman.data.remote.dtos.hotels.ResultsHotelItemDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HotelApiService {

    @GET("api/housing/housing")
    suspend fun getHotelResult(
        @Query("housing_type") housing_type: String = "",
        @Query("accommodation_type") accommodation_type: String = "",
        @Query("food_type") food_type: String = "",
        @Query("stars") stars: String = "",
        @Query("free_internet") free_internet: String = "",
        @Query("restaurant") restaurant: String = "",
        @Query("airport_transfer") airport_transfer: String = "",
        @Query("car_rental") car_rental: String = "",
        @Query("gym") gym: String = "",
        @Query("children_playground") children_playground: String = "",
        @Query("park") park: String = "",
        @Query("spa_services") spa_services: String = "",
        @Query("bar") bar: String = "",
        @Query("pool") pool: String = "",
        @Query("room_service") room_service: String = "",
        @Query("poolside_bar") poolside_bar: String = "",
        @Query("cafe") cafe: String = "",
        @Query("in_room_internet") in_room_internet: String = "",
        @Query("hotel_wide_internet") hotel_wide_internet: String = "",
        @Query("rating_range") rating_range: String = "",
        @Query("ordering") ordering: String = "",
        @Query("limit") limit: Int = 0,
        @Query("offset") offset: Int = 0
    ): HotelsDto

    @GET("api/housing/housing/{id}/")
    suspend fun getHotelById(
        @Path("id") id: Int
    ): ResultsHotelItemDto

}