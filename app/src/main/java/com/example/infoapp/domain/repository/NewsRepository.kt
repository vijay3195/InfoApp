package com.example.infoapp.domain.repository

import com.example.infoapp.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getTopNews(): Flow<List<News>>
}