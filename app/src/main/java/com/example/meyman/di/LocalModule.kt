package com.example.meyman.di

import android.content.Context
import com.example.meyman.data.remote.preferences.PreferenceHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun providePreferenceHelper(@ApplicationContext context: Context) = PreferenceHelper(context)

}