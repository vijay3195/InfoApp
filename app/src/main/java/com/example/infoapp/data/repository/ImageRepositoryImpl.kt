package com.example.infoapp.data.repository

import com.example.infoapp.data.remote.ImageApi
import com.example.infoapp.domain.model.Image
import com.example.infoapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: ImageApi
) : ImageRepository {
    override fun getRandomImage(): Flow<Image> = flow {
        val response = api.getRandomImage()
        emit(Image(url = response.urls.regular))
    }
}