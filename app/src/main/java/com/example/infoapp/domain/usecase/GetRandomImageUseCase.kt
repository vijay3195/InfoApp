package com.example.infoapp.domain.usecase

import com.example.infoapp.domain.model.Image
import com.example.infoapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomImageUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    operator fun invoke(): Flow<Image> = repository.getRandomImage()
}