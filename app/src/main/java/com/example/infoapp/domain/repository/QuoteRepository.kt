package com.example.infoapp.domain.repository


import com.example.infoapp.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    fun getQuote(): Flow<Quote>
}