package com.news.aware.ui.home

import androidx.lifecycle.ViewModel
import com.news.aware.common.Resource
import com.news.aware.data.news_api.GetArticles
import com.news.aware.domain.models.ArticleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getArticlesCase: GetArticles
): ViewModel(){

    private val _articleState = MutableStateFlow(ArticleState())
    val articleState = _articleState.asStateFlow()

    init {
        getArticles()
    }
    fun getArticles(category: String = "AI"){
        getArticlesCase(category, getDate()).onEach {result ->
            when(result){
                is Resource.Success ->{
                    _articleState.tryEmit(
                        ArticleState(
                        articles = result.data
                    )
                    )
                }
                is Resource.Error ->{
                    _articleState.tryEmit(ArticleState(
                        error = result.message ?: DEFAULT_ERROR
                    ))
                }
                is Resource.Loading ->{
                    _articleState.tryEmit(ArticleState(
                        articles = result.data
                    ))
                }
            }

        }
    }

    private fun getDate() : String{
        val monthAgo = LocalDate.now().minusDays(30)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return monthAgo.format(formatter)
    }

    companion object{
        const val DEFAULT_ERROR = "Something went wrong"
    }
}