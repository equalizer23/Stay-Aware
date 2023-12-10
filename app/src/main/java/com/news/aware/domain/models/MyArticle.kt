package com.news.aware.domain.models

import com.news.aware.common.Constants
import com.news.aware.domain.dto.Article
import kotlinx.serialization.Serializable

@Serializable
data class MyArticle(
    val title: String,
    val author: String,
    val content: String,
    val description: String,
    val image: String,
    val url: String
)

fun Article.toArticle() : MyArticle =
    MyArticle(
        title = this.title,
        author = this.author,
        content = this.content,
        description = this.description,
        image = this.urlToImage ?: Constants.NEWS_IMAGE,
        url = this.url

    )