package com.example.infoapp.presentation.weather

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    val weather = viewModel.weatherState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.loadWeather("Delhi")
    }

    Column(modifier = Modifier.padding(24.dp)) {
        if (weather != null) {
            Text(text = "City: ${weather.city}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Temperature: ${weather.temperature}")
        } else {
            Text("Loading weather...")
        }
    }
}