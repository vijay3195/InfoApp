package com.example.infoapp.data.model

data class WeatherResponse(
    val name: String, // city name
    val main: Main
)

data class Main(
    val temp: Double // temperature
)