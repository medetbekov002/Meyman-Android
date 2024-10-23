package com.example.meyman.presentation.models.rooms.page

import com.example.meyman.data.remote.dtos.rooms.page.RoomDto
import com.example.meyman.data.remote.dtos.rooms.page.toDomain
import com.example.meyman.domain.utils.models.rooms.page.RoomImagesItemModel
import com.example.meyman.domain.utils.models.rooms.page.RoomModel
import com.google.gson.annotations.SerializedName

data class RoomUI(
    @SerializedName("king_bed")
    val kingBed: Int = 0,
    @SerializedName("room_amenities")
    val roomAmenities: List<String>?,
    @SerializedName("queen_bed")
    val queenBed: Int = 0,
    @SerializedName("max_guest_capacity")
    val maxGuestCapacity: Int = 0,
    @SerializedName("smoking_allowed")
    val smokingAllowed: Boolean = false,
    @SerializedName("housing")
    val housing: Int = 0,
    @SerializedName("bed_type")
    val bedType: List<String>?,
    @SerializedName("price_per_night_converted")
    val pricePerNightConverted: Int = 0,
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
    @SerializedName("sofa_bed")
    val sofaBed: Int = 0,
    @SerializedName("outside")
    val outside: List<String>?,
    @SerializedName("price_per_night")
    val pricePerNight: String = "",
    @SerializedName("room_images")
    val roomImages: List<RoomImagesItemUI>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("kitchen")
    val kitchen: List<String>?,
    @SerializedName("double_bed")
    val doubleBed: Int = 0,
    @SerializedName("bathroom")
    val bathroom: List<String>?
)

fun RoomModel.toUI() = RoomUI(
    kingBed,
    roomAmenities,
    queenBed,
    maxGuestCapacity,
    smokingAllowed,
    housing,
    bedType,
    pricePerNightConverted,
    roomArea,
    numRooms,
    bedrooms,
    roomName,
    singleBed,
    freeCancellationAnytime,
    sofaBed,
    outside,
    pricePerNight,
    roomImages?.map { it.toUI() },
    id,
    kitchen,
    doubleBed,
    bathroom
)

data class RoomImagesItemUI(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("room")
    val room: Int = 0
)

fun RoomImagesItemModel.toUI() = RoomImagesItemUI(
    image,
    id,
    room
)