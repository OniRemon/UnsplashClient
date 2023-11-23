package com.example.unsplashclient.di

import com.example.unsplashclient.common.Constants.BASE_URL
import com.example.unsplashclient.data.remote.UnsplashAPI
import com.example.unsplashclient.data.repository.PhotoRepositoryImpl
import com.example.unsplashclient.domain.repository.PhotoRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideUnsplashApi(): UnsplashAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(UnsplashAPI::class.java)
    }

    @Provides
    @Singleton
    fun providePhotoRepository(api: UnsplashAPI):PhotoRepository {
        return PhotoRepositoryImpl(api)
    }
}