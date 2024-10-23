package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.profile.ChangeUserProfileDto
import com.example.meyman.data.remote.dtos.profile.password.AnswerChangeUserPasswordDto
import com.example.meyman.data.remote.dtos.profile.password.ChangeUserPasswordDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part

interface UserProfileApiService {

    @GET("api/users/profile/{id}/")
    suspend fun fetchUserProfile(
//        @Path("id") id: Int,
        @Header("Authorization") token: String,
    ): ChangeUserProfileDto

    @Multipart
    @PUT("api/users/profile/{id}/")
    suspend fun fetchChangeUserProfile(
        @Header("Authorization") token: String,
        @Part image : MultipartBody.Part?,
        @Part("username") username : RequestBody,
        @Part("phoneNumber") phoneNumber : RequestBody
        ): ChangeUserProfileDto

    @POST("api/users/change-password/")
    suspend fun fetchChangeUserPassword(
        @Header("Authorization") token: String,
        @Body changeUserPasswordDto: ChangeUserPasswordDto
    ): AnswerChangeUserPasswordDto
}