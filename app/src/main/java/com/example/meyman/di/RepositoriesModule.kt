package com.example.meyman.di

import com.example.meyman.data.repositories.AdvertisingRepositoryImpl
import com.example.meyman.data.repositories.HotelRepositoryImpl
import com.example.meyman.data.repositories.LoginRepositoryImpl
import com.example.meyman.data.repositories.RegisterRepositoryImpl
import com.example.meyman.data.repositories.ReservationRepoImpl
import com.example.meyman.data.repositories.ResetPasswordRepositoryImpl
import com.example.meyman.data.repositories.RoomsRepositoryImpl
import com.example.meyman.data.repositories.TokenRepositoryImpl
import com.example.meyman.data.repositories.UserProfileRepositoryImpl
import com.example.meyman.data.repositories.VerifyAccountRepositoryImpl
import com.example.meyman.data.repositories.WishlistRepositoryImpl
import com.example.meyman.domain.repositories.AdvertisingRepository
import com.example.meyman.domain.repositories.HotelRepository
import com.example.meyman.domain.repositories.LoginRepository
import com.example.meyman.domain.repositories.RegisterRepository
import com.example.meyman.domain.repositories.ReservationRepo
import com.example.meyman.domain.repositories.ResetPasswordRepository
import com.example.meyman.domain.repositories.RoomsRepository
import com.example.meyman.domain.repositories.TokenRepository
import com.example.meyman.domain.repositories.UserProfileRepository
import com.example.meyman.domain.repositories.VerifyAccountRepository
import com.example.meyman.domain.repositories.WishlistRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun provideHotelRepository(repositoryImpl: HotelRepositoryImpl): HotelRepository

    @Binds
    fun provideRegisterRepository(repositoryImpl: RegisterRepositoryImpl): RegisterRepository

    @Binds
    fun provideVerifyAccountRepository(repositoryImpl: VerifyAccountRepositoryImpl): VerifyAccountRepository

    @Binds
    fun provideLoginRepository(repositoryImpl: LoginRepositoryImpl): LoginRepository

    @Binds
    fun provideAdvertisingRepository(repositoryImpl: AdvertisingRepositoryImpl): AdvertisingRepository

    @Binds
    fun provideUserProfileRepository(repositoryImpl: UserProfileRepositoryImpl): UserProfileRepository

    @Binds
    fun provideReservationRepo(repositoryImpl: ReservationRepoImpl): ReservationRepo

    @Binds
    fun provideRoomsRepository(repositoryImpl: RoomsRepositoryImpl): RoomsRepository

    @Binds
    fun provideResetPasswordRepository(repositoryImpl: ResetPasswordRepositoryImpl): ResetPasswordRepository

    @Binds
    fun provideTokenRepository(repositoryImpl: TokenRepositoryImpl): TokenRepository

    @Binds
    fun provideWishlistRepository(repositoryImpl: WishlistRepositoryImpl): WishlistRepository
}