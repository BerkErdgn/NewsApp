package com.example.newsappcompose.model

import com.google.gson.annotations.SerializedName

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)