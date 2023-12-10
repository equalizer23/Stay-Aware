package com.news.aware.data.news_api

import com.news.aware.common.Constants
import com.news.aware.common.decode
import com.news.aware.domain.dto.Article
import com.news.aware.domain.dto.MyResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import io.ktor.serialization.kotlinx.json.json

class ApiClient : ApiRepo{
    private val client: HttpClient = HttpClient{
        install(ContentNegotiation){
            json()
        }
    }

    override suspend fun getArticles(category: String, date: String): List<Article> {
        return try{
            val response: MyResponse  = client.get(Constants.BASE_URl){
                url{
                    appendPathSegments("v2", "everything")
                    parameters.apply {
                        append("q", category)
                        append("from", date)
                        append("sortBy", "publishedAt")
                        append("apiKey", Constants.API_KEY.decode())
                    }

                }
            }.body()
            response.articles
        }catch(e: Exception){
            emptyList()
        }finally {
            client.close()
        }
    }
}