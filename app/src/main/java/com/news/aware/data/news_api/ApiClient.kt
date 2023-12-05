package com.news.aware.data.news_api

import com.news.aware.domain.models.Article
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

class ApiClient : ApiRepo{
    private val client: HttpClient = HttpClient{
        install(ContentNegotiation){
            json()
        }
    }

    override suspend fun getArticles(): List<Article> {

    }


}