package com.example.infoapp.data.remote

import com.example.infoapp.data.model.QuoteResponse
import retrofit2.http.GET

interface QuoteApi {
    @GET("random")
    suspend fun getRandomQuote(): List<QuoteResponse>
}