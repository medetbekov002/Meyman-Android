package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.HotelsHousingImage
import com.example.meyman.domain.utils.models.HotelsModel
import com.google.gson.annotations.SerializedName

data class HotelsDto(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: Any,
    @SerializedName("previous") val previous: Any,
    @SerializedName("results") val results: List<HotelsResult>
)

fun HotelsDto.toDomain() = HotelsModel(count, next, previous, results.map { it.toDomain() })

data class HotelsHousingImage(
    @SerializedName("housing") val housing: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String
)

fun HotelsHousingImage.toDomain() = HotelsHousingImage(
    housing, id, image
)

data class HotelsResult(
    @SerializedName("address") val address: String,
    @SerializedName("airport_transfer") val airport_transfer: Boolean,
    @SerializedName("average_rating") val average_rating: Double,
    @SerializedName("bar") val bar: Boolean,
    @SerializedName("breakfast_type") val breakfast_type: List<String>,
    @SerializedName("cafe") val cafe: Boolean,
    @SerializedName("car_rental") val car_rental: Boolean,
    @SerializedName("cheapest_room_price") val cheapest_room_price: Double,
    @SerializedName("check_in_time_end") val check_in_time_end: String,
    @SerializedName("check_in_time_start") val check_in_time_start: String,
    @SerializedName("check_out_time_end") val check_out_time_end: String,
    @SerializedName("check_out_time_start") val check_out_time_start: String,
    @SerializedName("children_playground") val children_playground: Boolean,
    @SerializedName("free_internet") val free_internet: Boolean,
    @SerializedName("gym") val gym: Boolean,
    @SerializedName("hotel_wide_internet") val hotel_wide_internet: Boolean,
    @SerializedName("housing_image") val housing_image: String,
    @SerializedName("housing_images") val housing_images: List<HotelsHousingImage>,
    @SerializedName("housing_name") val housing_name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("in_room_internet") val in_room_internet: Boolean,
    @SerializedName("location") val location: String,
    @SerializedName("paid_bar") val paid_bar: Boolean,
    @SerializedName("paid_parking") val paid_parking: Boolean,
    @SerializedName("paid_transfer") val paid_transfer: Boolean,
    @SerializedName("park") val park: Boolean,
    @SerializedName("pool") val pool: Boolean,
    @SerializedName("poolside_bar") val poolside_bar: Boolean,
    @SerializedName("restaurant") val restaurant: Boolean,
    @SerializedName("reviews") val reviews: List<HotelsReview>,
    @SerializedName("room_service") val room_service: Boolean,
    @SerializedName("rooms") val rooms: List<HotelsRoom>,
    @SerializedName("spa_services") val spa_services: Boolean,
    @SerializedName("stars") val stars: Int,
    @SerializedName("user") val user: Int
)

fun HotelsResult.toDomain() = com.example.meyman.domain.utils.models.HotelsResultDomain(
    address,
    airport_transfer,
    average_rating,
    bar,
    breakfast_type,
    cafe,
    car_rental,
    cheapest_room_price,
    check_in_time_end,
    check_in_time_start,
    check_out_time_end,
    check_out_time_start,
    children_playground,
    free_internet,
    gym,
    hotel_wide_internet,
    housing_image,
    housing_images.map { it.toDomain() },
    housing_name,
    id,
    in_room_internet,
    location,
    paid_bar,
    paid_parking,
    paid_transfer,
    park,
    pool,
    poolside_bar,
    restaurant,
    reviews.map { it.toDomain() },
    room_service,
    rooms.map { it.toDomain() },
    spa_services,
    stars,
    user
)

data class HotelsReview(
    @SerializedName("cleanliness_rating") val cleanliness_rating: Int,
    @SerializedName("comfort_rating") val comfort_rating: Int,
    @SerializedName("comment") val comment: String,
    @SerializedName("date_added") val date_added: String,
    @SerializedName("food_rating") val food_rating: Int,
    @SerializedName("housing") val housing: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("location_rating") val location_rating: Int,
    @SerializedName("staff_rating") val staff_rating: Int,
    @SerializedName("value_for_money_rating") val value_for_money_rating: Int
)

fun HotelsReview.toDomain() = com.example.meyman.domain.utils.models.HotelsReview(
    cleanliness_rating,
    comfort_rating,
    comment,
    date_added,
    food_rating,
    housing,
    id,
    location_rating,
    staff_rating,
    value_for_money_rating
)

data class HotelsRoom(
    @SerializedName("Free_cancellation_anytime") val Free_cancellation_anytime: Boolean,
    @SerializedName("bathroom") val bathroom: List<String>,
    @SerializedName("bed_type") val bed_type: List<String>,
    @SerializedName("housing") val housing: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("kitchen") val kitchen: List<String>,
    @SerializedName("max_guest_capacity") val max_guest_capacity: Int,
    @SerializedName("num_rooms") val num_rooms: Int,
    @SerializedName("outside") val outside: List<String>,
    @SerializedName("price_per_night") val price_per_night: String,
    @SerializedName("room_amenities") val room_amenities: List<String>,
    @SerializedName("room_area") val room_area: Int,
    @SerializedName("room_images") val room_images: List<HotelsRoomImage>,
    @SerializedName("room_name") val room_name: String
)

fun HotelsRoom.toDomain() = com.example.meyman.domain.utils.models.HotelsRoom(
    Free_cancellation_anytime,
    bathroom,
    bed_type,
    housing,
    id,
    kitchen,
    max_guest_capacity,
    num_rooms,
    outside,
    price_per_night,
    room_amenities,
    room_area,
    room_images.map { it.toDomain() },
    room_name
)

data class HotelsRoomImage(
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("room") val room: Int
)

fun HotelsRoomImage.toDomain() = com.example.meyman.domain.utils.models.HotelsRoomImage(
    id, image, room
)