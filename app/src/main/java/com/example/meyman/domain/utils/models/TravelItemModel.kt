package com.example.meyman.domain.utils.models


data class TravelItemModel(
    val id: String,
    val description: String,
    val housing_name: String,
    val housing_amenities: HousingAmenitiesModel,
)
