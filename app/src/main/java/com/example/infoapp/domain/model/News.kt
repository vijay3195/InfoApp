package com.example.infoapp.domain.model

data class News(
    val title: String,
    val description: String,
    val imageUrl: String?,
    val articleUrl: String
)