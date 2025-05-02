package com.example.infoapp.domain.usecase

import com.example.infoapp.domain.model.Quote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.example.infoapp.domain.repository.QuoteRepository

class GetQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    operator fun invoke(): Flow<Quote> = repository.getQuote()
}