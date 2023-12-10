package com.news.aware.ui.home

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.news.aware.common.Constants
import com.news.aware.domain.models.Category
import com.news.aware.domain.models.MyArticle
import com.news.aware.domain.models.toArticle
import com.news.aware.navigation.Navigator
import com.news.aware.ui.components.ArticleItem
import com.news.aware.ui.components.Background
import com.news.aware.ui.components.CategoryItem
import com.news.aware.ui.components.CoolText
import com.news.aware.ui.components.CustomField
import com.news.aware.ui.components.CustomLoading


@Composable
fun HomeScreen(
    navigator: Navigator,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val articleState by viewModel.articleState.collectAsState()

    val categories = listOf(
        Category.AI,
        Category.Ukraine,
        Category.Tesla,
        Category.Israel,
        Category.Apple,
    )

    Box(modifier = modifier.fillMaxSize()){
        Background()

        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomField(modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 20.dp)
            )

            Divider(color = Color.Black, thickness = 2.dp, modifier = Modifier.fillMaxWidth())
            LazyRow(modifier = modifier.padding(start = 8.dp, top = 20.dp, bottom = 20.dp)){
                items(categories.size){
                    CategoryItem(category = categories[it])
                }
            }
            Divider(color = Color.Black, thickness = 2.dp, modifier = Modifier.fillMaxWidth())
            if(articleState.isLoading){
                Box {
                    CustomLoading()
                }
            }
            if(articleState.error.isNotBlank()){
                Box {
                    CoolText(text = articleState.error, size = 24)
                }
            }
            if(articleState.articles.isNotEmpty()){
                LazyColumn(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)){
                    items(articleState.articles.size){
                        val article = articleState.articles[it].toArticle()

                        Log.i("Article", article.toString())

                        ArticleItem(article = article){
                            navigator.toPage("${Constants.FULL_ARTICLE_ROUTE}/$article", null)
                        }
                    }
                }
            }
        }
    }
}