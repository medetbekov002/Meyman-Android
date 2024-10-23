package com.example.meyman.data.remote.dtos.hotels

import com.example.meyman.domain.utils.models.hotels.HotelsModel
import com.example.meyman.domain.utils.models.hotels.HousingImagesItemModel
import com.example.meyman.domain.utils.models.hotels.ResultsHotelItemModel
import com.example.meyman.domain.utils.models.hotels.ReviewsHotelItemModel
import com.example.meyman.presentation.models.rooms.list.ResultsRoomsListItemUI
import com.google.gson.annotations.SerializedName

data class HotelsDto(
    @SerializedName("next")
    val next: String = "",
    @SerializedName("previous")
    val previous: String,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<ResultsHotelItemDto>?
)

fun HotelsDto.toDomain() = HotelsModel(
    next,
    previous,
    count,
    results?.map { it.toDomain() }
)

data class HousingImagesItemDto(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("housing")
    val housing: Int = 0,
    @SerializedName("id")
    val id: Int = 0
)

fun HousingImagesItemDto.toDomain() = HousingImagesItemModel(
    image,
    housing,
    id
)

data class ResultsHotelItemDto(
    @SerializedName("check_out_time_end")
    val checkOutTimeEnd: String = "",
//    @SerializedName("parking_location")
//    val parkingLocation: String = "",
    @SerializedName("room_service")
    val roomService: Boolean = false,
    @SerializedName("accommodation_type")
    val accommodationType: String = "",
    @SerializedName("pet_fee")
    val petFee: Boolean = false,
    @SerializedName("paid_parking")
    val paidParking: Boolean = false,
    @SerializedName("poolside_bar")
    val poolsideBar: Boolean = false,
    @SerializedName("children_allowed")
    val childrenAllowed: Boolean = false,
    @SerializedName("spa_services")
    val spaServices: Boolean = false,
    @SerializedName("bar")
    val bar: Boolean = false,
    @SerializedName("reviews")
    val reviews: List<ReviewsHotelItemDto>?,
    @SerializedName("in_room_internet")
    val inRoomInternet: Boolean = false,
    @SerializedName("check_out_time_start")
    val checkOutTimeStart: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("housing_images")
    val housingImages: List<HousingImagesItemDto>?,
    @SerializedName("free_internet")
    val freeInternet: Boolean = false,
    @SerializedName("park")
    val park: Boolean = false,
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("check_in_time_end")
    val checkInTimeEnd: String = "",
    @SerializedName("airport_transfer")
    val airportTransfer: Boolean = false,
//    @SerializedName("cheapest_room_price")
//    val cheapestRoomPrice: String,
    @SerializedName("paid_transfer")
    val paidTransfer: Boolean = false,
    @SerializedName("address")
    val address: String = "",
    @SerializedName("children_playground")
    val childrenPlayground: Boolean = false,
    @SerializedName("restaurant")
    val restaurant: Boolean = false,
    @SerializedName("pool")
    val pool: Boolean = false,
    @SerializedName("pets_allowed")
    val petsAllowed: Boolean = false,
    @SerializedName("housing_image")
    val housingImage: String = "",
    @SerializedName("average_rating")
    val averageRating: Double = 0.0,
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
    @SerializedName("location")
    val location: String = "",
    @SerializedName("paid_bar")
    val paidBar: Boolean = false,
    @SerializedName("gym")
    val gym: Boolean = false,
//    @SerializedName("breakfast_cost_usd")
//    val breakfastCostUsd: String,
    @SerializedName("rooms")
    val rooms: List<ResultsRoomsListItemUI>,
    @SerializedName("housing_type")
    val housingType: String = "",
    @SerializedName("region")
    val region: String = ""
)

fun ResultsHotelItemDto.toDomain() = ResultsHotelItemModel(
    checkOutTimeEnd,
//    parkingLocation,
    roomService,
    accommodationType,
    petFee,
    paidParking,
    poolsideBar,
    childrenAllowed,
    spaServices,
    bar,
    reviews?.map { it.toDomain() },
    inRoomInternet,
    checkOutTimeStart,
    id,
    housingImages?.map { it.toDomain() },
    freeInternet,
    park,
    slug,
    checkInTimeEnd,
    airportTransfer,
//    cheapestRoomPrice,
    paidTransfer,
    address,
    childrenPlayground,
    restaurant,
    pool,
    petsAllowed,
    housingImage,
    averageRating,
    stars,
    foodType,
    checkInTimeStart,
    housingName,
    cafe,
    hotelWideInternet,
    carRental,
    location,
    paidBar,
    gym,
//    breakfastCostUsd,
    rooms,
    housingType,
    region
)

data class ReviewsHotelItemDto(
    @SerializedName("food_rating")
    val foodRating: Int = 0,
    @SerializedName("date_added")
    val dateAdded: String = "",
    @SerializedName("cleanliness_rating")
    val cleanlinessRating: Int = 0,
    @SerializedName("housing")
    val housing: Int = 0,
    @SerializedName("comfort_rating")
    val comfortRating: Int = 0,
    @SerializedName("value_for_money_rating")
    val valueForMoneyRating: Int = 0,
    @SerializedName("comment")
    val comment: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("location_rating")
    val locationRating: Int = 0,
    @SerializedName("staff_rating")
    val staffRating: Int = 0
)

fun ReviewsHotelItemDto.toDomain() = ReviewsHotelItemModel(
    foodRating,
    dateAdded,
    cleanlinessRating,
    housing,
    comfortRating,
    valueForMoneyRating,
    comment, id,
    locationRating,
    staffRating
)