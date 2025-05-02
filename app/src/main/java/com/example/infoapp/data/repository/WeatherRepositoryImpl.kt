package com.example.infoapp.data.repository

import com.example.infoapp.data.remote.WeatherApi
import com.example.infoapp.domain.model.Weather
import com.example.infoapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override fun getWeather(city: String): Flow<Weather> = flow {
        val response = api.getWeatherByCity(city)
        val weather = Weather(
            city = response.name,
            temperature = "${response.main.temp}°C"
        )
        emit(weather)
    }
}