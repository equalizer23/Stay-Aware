package com.news.aware.domain.dto

import kotlinx.serialization.Serializable


@Serializable
data class MyResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
