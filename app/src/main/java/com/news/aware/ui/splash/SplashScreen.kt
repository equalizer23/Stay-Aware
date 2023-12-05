package com.news.aware.ui.splash

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.news.aware.common.Constants
import com.news.aware.navigation.Navigator
import com.news.aware.ui.components.CustomLoading
import com.news.aware.ui.components.FadeText
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(controller: NavHostController, modifier: Modifier = Modifier) {
    val navigator = Navigator(controller)

    val alpha by animateFloatAsState(
        targetValue = 1f,
        label = "Fade In",
        animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing, delayMillis = 2000)
    )

//    LaunchedEffect(key1 = null){
//        delay(4000L)
//        navigator.toPage(Constants.HOME_SCREEN_ROUTE, Constants.SPLASH_SCREEN_ROUTE)
//    }

    Box(modifier = modifier.fillMaxSize()){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(horizontalArrangement = Arrangement.Center){
                FadeText(text = "Stay", delay = 500, size = 42)
                FadeText(text = "Aware", delay = 1000, size = 42)
            }

            CustomLoading(modifier = modifier.alpha(alpha).size(200.dp).padding(top = 40.dp))
        }
    }
}