package com.example.infoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.infoapp.presentation.dashboard.DashboardScreen
import com.example.infoapp.presentation.news.NewsScreen
import com.example.infoapp.presentation.quote.QuoteScreen
import com.example.infoapp.presentation.random_image.RandomImageScreen
import com.example.infoapp.presentation.splash.SplashScreen
import com.example.infoapp.presentation.weather.WeatherScreen


@Composable
fun NavGraph(navController: NavHostController = rememberNavController(),
             startDestination: String = "splash") {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("splash") { SplashScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("weather") { WeatherScreen() }
        composable("news") { NewsScreen() }
        composable("quote") { QuoteScreen() }
        composable("images") { RandomImageScreen() }
    }
}