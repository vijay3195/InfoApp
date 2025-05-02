package com.example.infoapp.data.remote

import com.example.infoapp.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "c608a4dfa7024405a4f422962b4b07e9" //https://newsapi.org/account
    ): NewsResponse
}