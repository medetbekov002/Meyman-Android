//package com.example.meyman.presentation.models
//
//import android.os.Parcelable
//import com.example.meyman.domain.utils.models.TravelItemModel
//import kotlinx.parcelize.Parcelize
//import kotlinx.serialization.SerialName
//
//
//@Parcelize
//data class TravelItemUI(
//    @SerialName("id")
//    val id: String,
//    @SerialName("description")
//    val description: String,
//    @SerialName("housing_name")
//    val housing_name: String,
//    @SerialName("housing_amenities")
//    val housing_amenities: HousingAmenitiesUI,
//): Parcelable
//
//fun TravelItemModel.toUI() = TravelItemUI(
//    id,
//    description,
//    housing_name,
//    housing_amenities.toUI()
//)
