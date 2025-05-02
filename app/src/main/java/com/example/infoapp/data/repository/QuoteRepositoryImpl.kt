package com.example.infoapp.data.repository


import com.example.infoapp.data.remote.QuoteApi
import com.example.infoapp.domain.model.Quote
import com.example.infoapp.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val api: QuoteApi
) : QuoteRepository {
    override fun getQuote(): Flow<Quote> = flow {
        val response = api.getRandomQuote().first()
        emit(Quote(content = response.q, author = response.a))
    }
}