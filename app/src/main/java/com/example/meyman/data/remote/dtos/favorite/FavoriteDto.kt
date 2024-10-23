package com.example.meyman.data.remote.dtos.favorite

import com.google.gson.annotations.SerializedName

data class FavoriteDto(
    @SerializedName("check_out_time_end")
    val checkOutTimeEnd: String = "",
    @SerializedName("room_service")
    val roomService: Boolean = false,
    @SerializedName("parking_location")
    val parkingLocation: String = "",
    @SerializedName("accommodation_type")
    val accommodationType: String = "",
    @SerializedName("pet_fee")
    val petFee: Boolean = false,
    @SerializedName("housing")
    val housing: Int = 0,
    @SerializedName("paid_parking")
    val paidParking: Boolean = false,
    @SerializedName("breakfast_type")
    val breakfastType: List<String>?,
    @SerializedName("poolside_bar")
    val poolsideBar: Boolean = false,
    @SerializedName("wishlist_album")
    val wishlistAlbum: Int = 0,
    @SerializedName("children_allowed")
    val childrenAllowed: Boolean = false,
    @SerializedName("breakfast_included")
    val breakfastIncluded: Boolean = false,
    @SerializedName("spa_services")
    val spaServices: Boolean = false,
    @SerializedName("bar")
    val bar: Boolean = false,
    @SerializedName("in_room_internet")
    val inRoomInternet: Boolean = false,
    @SerializedName("check_out_time_start")
    val checkOutTimeStart: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("free_internet")
    val freeInternet: Boolean = false,
    @SerializedName("park")
    val park: Boolean = false,
    @SerializedName("breakfast_offered")
    val breakfastOffered: Boolean = false,
    @SerializedName("check_in_time_end")
    val checkInTimeEnd: String = "",
    @SerializedName("cheapest_room_price")
    val cheapestRoomPrice: Int = 0,
    @SerializedName("airport_transfer")
    val airportTransfer: Boolean = false,
    @SerializedName("address")
    val address: String = "",
    @SerializedName("paid_transfer")
    val paidTransfer: Boolean = false,
    @SerializedName("children_playground")
    val childrenPlayground: Boolean = false,
    @SerializedName("restaurant")
    val restaurant: Boolean = false,
    @SerializedName("pool")
    val pool: Boolean = false,
    @SerializedName("pets_allowed")
    val petsAllowed: Boolean = false,
    @SerializedName("housing_image")
    val housingImage: List<String>?,
    @SerializedName("stars")
    val stars: Int = 0,
    @SerializedName("food_type")
    val foodType: String = "",
    @SerializedName("check_in_time_start")
    val checkInTimeStart: String = "",
    @SerializedName("housing_name")
    val housingName: String = "",
    @SerializedName("cafe")
    val cafe: Boolean = false,
    @SerializedName("hotel_wide_internet")
    val hotelWideInternet: Boolean = false,
    @SerializedName("car_rental")
    val carRental: Boolean = false,
    @SerializedName("gym")
    val gym: Boolean = false,
    @SerializedName("paid_bar")
    val paidBar: Boolean = false,
    @SerializedName("breakfast_cost_usd")
    val breakfastCostUsd: Int,
    @SerializedName("region")
    val region: String = "",
    @SerializedName("housing_type")
    val housingType: String = ""
)