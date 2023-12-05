package com.news.aware.ui.app

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.news.aware.navigation.RootNavigation
import com.news.aware.ui.theme.StayAwareTheme

@Composable
fun AppScreen(activity: ComponentActivity) {
    StayAwareTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navHostController = rememberNavController()

            RootNavigation(
                navHostController = navHostController,
                context = activity
            )
        }
    }
}