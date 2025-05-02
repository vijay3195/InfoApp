package com.example.infoapp.domain.usecase

import com.example.infoapp.domain.model.News
import com.example.infoapp.domain.repository.NewsRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetTopNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<List<News>> = repository.getTopNews()
}