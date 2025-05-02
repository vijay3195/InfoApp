package com.example.infoapp.data.remote

import com.example.infoapp.data.model.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("photos/random")
    suspend fun getRandomImage(
        @Query("client_id") clientId: String = "4tZvdN0n4wjuOnMUBwACd8O90XFNGJBz4lY9gC5liug" //https://unsplash.com/oauth/applications/744987
    ): ImageResponse
}