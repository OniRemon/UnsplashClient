package com.example.unsplashclient.data.repository

import com.example.unsplashclient.data.remote.PhotoDetailDto
import com.example.unsplashclient.data.remote.SearchPhotosResultDto
import com.example.unsplashclient.data.remote.UnsplashAPI
import com.example.unsplashclient.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api : UnsplashAPI,
): PhotoRepository{
    override suspend fun searchPhotos(query: String): SearchPhotosResultDto {
        return api.searchPhotos(query)
    }

    override suspend fun getPhotoById(id: String): PhotoDetailDto {
        return api.getPhotoById(id)
    }
}