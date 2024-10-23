//package com.example.meyman.domain.usecases
//
//import com.example.meyman.domain.repositories.BookingRepository
//import javax.inject.Inject
//
//class BookingDetailsUseCase @Inject constructor(
//    private val bookingRepository: BookingRepository
//) {
//
//    suspend operator fun invoke(id: Int) = bookingRepository.getBookingById(id)
//
//}