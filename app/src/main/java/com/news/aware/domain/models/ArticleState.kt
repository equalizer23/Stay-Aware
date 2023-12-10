package com.news.aware.domain.models

import com.news.aware.domain.dto.Article

data class ArticleState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""
)
