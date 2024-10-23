package com.example.meyman.domain.utils.models

data class HotelsModel(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<HotelsResultDomain>
)

data class HotelsHousingImage(
    val housing: Int,
    val id: Int,
    val image: String
)

data class HotelsResultDomain(
    val address: String,
    val airport_transfer: Boolean,
    val average_rating: Double,
    val bar: Boolean,
    val breakfast_type: List<String>,
    val cafe: Boolean,
    val car_rental: Boolean,
    val cheapest_room_price: Double,
    val check_in_time_end: String,
    val check_in_time_start: String,
    val check_out_time_end: String,
    val check_out_time_start: String,
    val children_playground: Boolean,
    val free_internet: Boolean,
    val gym: Boolean,
    val hotel_wide_internet: Boolean,
    val housing_image: String,
    val housing_images: List<HotelsHousingImage>,
    val housing_name: String,
    val id: Int,
    val in_room_internet: Boolean,
    val location: String,
    val paid_bar: Boolean,
    val paid_parking: Boolean,
    val paid_transfer: Boolean,
    val park: Boolean,
    val pool: Boolean,
    val poolside_bar: Boolean,
    val restaurant: Boolean,
    val reviews: List<HotelsReview>,
    val room_service: Boolean,
    val rooms: List<HotelsRoom>,
    val spa_services: Boolean,
    val stars: Int,
    val user: Int
)

data class HotelsReview(
    val cleanliness_rating: Int,
    val comfort_rating: Int,
    val comment: String,
    val date_added: String,
    val food_rating: Int,
    val housing: Int,
    val id: Int,
    val location_rating: Int,
    val staff_rating: Int,
    val value_for_money_rating: Int
)

data class HotelsRoom(
    val Free_cancellation_anytime: Boolean,
    val bathroom: List<String>,
    val bed_type: List<String>,
    val housing: Int,
    val id: Int,
    val kitchen: List<String>,
    val max_guest_capacity: Int,
    val num_rooms: Int,
    val outside: List<String>,
    val price_per_night: String,
    val room_amenities: List<String>,
    val room_area: Int,
    val room_images: List<HotelsRoomImage>,
    val room_name: String
)

data class HotelsRoomImage(
    val id: Int,
    val image: String,
    val room: Int
)
