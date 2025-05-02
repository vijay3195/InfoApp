package com.example.infoapp.domain.repository

import com.example.infoapp.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeather(city: String): Flow<Weather>
}