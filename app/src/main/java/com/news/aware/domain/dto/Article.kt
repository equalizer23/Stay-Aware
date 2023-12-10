package com.news.aware.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val source: Map<String, String?>,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String,
)
