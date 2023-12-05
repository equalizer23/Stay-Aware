package com.news.aware.navigation

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.news.aware.common.Constants
import com.news.aware.ui.home.HomeScreen
import com.news.aware.ui.splash.SplashScreen

@Composable
fun RootNavigation(
    navHostController: NavHostController,
    context: ComponentActivity,
) {
    NavHost(
        navController = navHostController,
        startDestination = Constants.SPLASH_SCREEN_ROUTE,
        route = Constants.ROOT_GRAPH
    ){
        composable(route = Constants.HOME_SCREEN_ROUTE){
            HomeScreen(context)
        }

        composable(route = Constants.SPLASH_SCREEN_ROUTE){
            SplashScreen(navHostController)
        }
    }
}