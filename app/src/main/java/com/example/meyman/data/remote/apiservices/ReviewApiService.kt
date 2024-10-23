package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.review.ReviewDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ReviewApiService {

    @GET("reviews/")
    fun fetchReview(
        @Query(value = "limit") limit : Int? = null ,
        @Query( value = "offset") offset: Int? = null,
        ): ReviewDto
}