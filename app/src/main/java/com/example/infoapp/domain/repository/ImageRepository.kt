package com.example.infoapp.domain.repository

import com.example.infoapp.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getRandomImage(): Flow<Image>
}