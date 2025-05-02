package com.example.infoapp.data.remote

import com.example.infoapp.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeatherByCity(
        @Query("q") city: String,
        @Query("appid") apiKey: String = "a1c69493f54efa936de77d80b2f0018e", //https://home.openweathermap.org/api_keys
        @Query("units") units: String = "metric"
    ): WeatherResponse
}