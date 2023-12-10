package com.news.aware.data.news_api

import com.news.aware.common.Resource
import com.news.aware.domain.dto.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetArticles @Inject constructor(
    private val apiRepo: ApiRepoImpl
) {
    operator fun invoke(category: String, date: String) : Flow<Resource<List<Article>>> = flow{
        try{
            emit(Resource.Loading())
            val articles = apiRepo.getArticles(category, date)
            emit(Resource.Success(data = articles))
        }catch(e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }catch(e: Exception){
            emit(Resource.Error(e.localizedMessage ?: "Something went wrong"))
        }
    }
}