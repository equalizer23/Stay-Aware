package com.news.aware.data.news_api

import com.news.aware.domain.models.Article

interface ApiRepo {

    //Returns a list of articles
    suspend fun getArticles(category: String, date: String) : List<Article>
}