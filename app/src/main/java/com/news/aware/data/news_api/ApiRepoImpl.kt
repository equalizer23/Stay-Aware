package com.news.aware.data.news_api

import com.news.aware.domain.dto.Article
import javax.inject.Inject

class ApiRepoImpl @Inject constructor(
    private val client: ApiClient
) : ApiRepo {
    override suspend fun getArticles(category: String, date: String): List<Article> =
        client.getArticles(category, date)
}