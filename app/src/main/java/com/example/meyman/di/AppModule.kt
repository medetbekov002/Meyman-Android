package com.example.meyman.di

import com.example.meyman.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideHotelApiService() = retrofitClient.provideHotelApiServer()

    @Singleton
    @Provides
    fun provideReviewApiService() = retrofitClient.provideReviewApiServer()

    @Singleton
    @Provides
    fun provideRegisterApiService() = retrofitClient.provideRegisterApiServer()

    @Singleton
    @Provides
    fun provideVerifyAccountApiService() = retrofitClient.provideVerifyAccount()

    @Singleton
    @Provides
    fun provideLoginApiService() = retrofitClient.provideLogin()

    @Singleton
    @Provides
    fun provideAdvertisingApiService() = retrofitClient.provideAdvertising()

    @Singleton
    @Provides
    fun provideUserProfileApiService() = retrofitClient.provideUserProfile()

    @Singleton
    @Provides
    fun provideReservationApi() = retrofitClient.provideReservationApi()

    @Singleton
    @Provides
    fun provideRoomsApiService() = retrofitClient.provideRooms()

    @Singleton
    @Provides
    fun provideResetPasswordApiService() = retrofitClient.provideResetPassword()

    @Singleton
    @Provides
    fun provideTokenApiService() = retrofitClient.provideTokenApi()

    @Singleton
    @Provides
    fun provideWishlistApiService() = retrofitClient.provideWishlistApi()
}