package com.example.meyman.domain.utils.models.rooms.list

import com.google.gson.annotations.SerializedName

data class RoomListModel(
    @SerializedName("next")
    val next: String = "",
    @SerializedName("previous")
    val previous: String,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<ResultsRoomsListItemModel>?
)

data class ResultsRoomsListItemModel(
//    @SerializedName("king_bed")
//    val kingBed: String,
    @SerializedName("room_amenities")
    val roomAmenities: List<String>?,
//    @SerializedName("queen_bed")
//    val queenBed: String,
    @SerializedName("max_guest_capacity")
    val maxGuestCapacity: Int = 0,
    @SerializedName("smoking_allowed")
    val smokingAllowed: Boolean = false,
    @SerializedName("housing")
    val housing: Int = 0,
    @SerializedName("bed_type")
    val bedType: List<String>?,
    @SerializedName("room_area")
    val roomArea: Int = 0,
    @SerializedName("num_rooms")
    val numRooms: Int = 0,
    @SerializedName("bedrooms")
    val bedrooms: String = "",
    @SerializedName("room_name")
    val roomName: String = "",
    @SerializedName("single_bed")
    val singleBed: Int = 0,
    @SerializedName("Free_cancellation_anytime")
    val freeCancellationAnytime: Boolean = false,
//    @SerializedName("sofa_bed")
//    val sofaBed: String,
    @SerializedName("outside")
    val outside: List<String>?,
    @SerializedName("price_per_night")
    val pricePerNight: String = "",
    @SerializedName("room_images")
    val roomImages: List<RoomListImagesItemModel>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("kitchen")
    val kitchen: List<String>?,
    @SerializedName("double_bed")
    val doubleBed: Int = 0,
    @SerializedName("bathroom")
    val bathroom: List<String>?
)

data class RoomListImagesItemModel(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("room")
    val room: Int = 0
)