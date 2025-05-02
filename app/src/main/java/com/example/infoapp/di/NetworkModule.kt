package com.example.infoapp.di

import com.example.infoapp.data.remote.ImageApi
import com.example.infoapp.data.remote.NewsApi
import com.example.infoapp.data.remote.QuoteApi
import com.example.infoapp.data.remote.WeatherApi
import com.example.infoapp.data.repository.ImageRepositoryImpl
import com.example.infoapp.data.repository.NewsRepositoryImpl
import com.example.infoapp.data.repository.QuoteRepositoryImpl
import com.example.infoapp.data.repository.WeatherRepositoryImpl
import com.example.infoapp.domain.repository.ImageRepository
import com.example.infoapp.domain.repository.NewsRepository
import com.example.infoapp.domain.repository.QuoteRepository
import com.example.infoapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Named("weatherBaseUrl")
    fun provideWeatherBaseUrl() = "https://api.openweathermap.org/data/2.5/"

    @Provides
    @Named("newsBaseUrl")
    fun provideNewsBaseUrl() = "https://newsapi.org/v2/"

    @Provides
    @Named("quoteBaseUrl")
    fun provideQuoteBaseUrl() = "https://zenquotes.io/api/"

    @Provides
    @Named("imageBaseUrl")
    fun provideImageBaseUrl() = "https://api.unsplash.com/"

    @Provides
    @Singleton
    fun provideRetrofit(@Named("baseUrl") baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideWeatherApi(@Named("weatherBaseUrl") baseUrl: String): WeatherApi =
        provideRetrofit(baseUrl).create(WeatherApi::class.java)

    @Provides
    @Singleton
    fun provideNewsApi(@Named("newsBaseUrl") baseUrl: String): NewsApi =
        provideRetrofit(baseUrl).create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideImageApi(@Named("imageBaseUrl") baseUrl: String): ImageApi =
        provideRetrofit(baseUrl).create(ImageApi::class.java)

    @Provides
    @Singleton
    fun provideQuoteApi(@Named("quoteBaseUrl") baseUrl: String): QuoteApi =
        provideRetrofit(baseUrl).create(QuoteApi::class.java)

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository =
        WeatherRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApi): NewsRepository =
        NewsRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideQuoteRepository(api: QuoteApi): QuoteRepository =
        QuoteRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideImageRepository(api: ImageApi): ImageRepository =
        ImageRepositoryImpl(api)

}