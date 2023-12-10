package com.news.aware.navigation

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.news.aware.common.Constants
import com.news.aware.domain.models.fromJson
import com.news.aware.ui.description.FullArticle
import com.news.aware.ui.home.HomeScreen
import com.news.aware.ui.splash.SplashScreen

@Composable
fun RootNavigation(
    navigator: Navigator,
    controller: NavHostController
) {
    NavHost(
        navController = controller,
        startDestination = Constants.SPLASH_SCREEN_ROUTE,
        route = Constants.ROOT_GRAPH
    ){
        composable(route = Constants.HOME_SCREEN_ROUTE){
            HomeScreen(navigator)
        }

        composable(route = Constants.SPLASH_SCREEN_ROUTE){
            SplashScreen(navigator)
        }

        composable(
            route = "${Constants.FULL_ARTICLE_ROUTE}/{article}",
            arguments = listOf(
                navArgument("article"){
                    type = NavType.StringType
                }
            )
            ){back ->
            val article = back.arguments?.getString("article")?.fromJson()
            Log.i("Article", article?.title.toString())
            FullArticle(article = article)
        }
    }
}