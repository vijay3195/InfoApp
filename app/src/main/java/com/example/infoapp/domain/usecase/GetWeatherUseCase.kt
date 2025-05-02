package com.example.infoapp.domain.usecase

import com.example.infoapp.domain.model.Weather
import com.example.infoapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(city: String): Flow<Weather> {
        return repository.getWeather(city)
    }
}