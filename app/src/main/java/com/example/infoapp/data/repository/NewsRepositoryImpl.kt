package com.example.infoapp.data.repository

import com.example.infoapp.data.remote.NewsApi
import com.example.infoapp.domain.model.News
import com.example.infoapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {

    override fun getTopNews(): Flow<List<News>> = flow {
        val response = api.getTopHeadlines()
        val newsList = response.articles.map {
            News(
                title = it.title,
                description = it.description ?: "",
                imageUrl = it.urlToImage,
                articleUrl = it.url
            )
        }
        emit(newsList)
    }
}