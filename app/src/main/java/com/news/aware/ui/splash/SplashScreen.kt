package com.news.aware.ui.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.news.aware.common.Constants
import com.news.aware.navigation.Navigator
import com.news.aware.ui.components.Background
import com.news.aware.ui.components.CustomLoading
import com.news.aware.ui.components.FadeText
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(controller: NavHostController, modifier: Modifier = Modifier) {
    val navigator = Navigator(controller)
    var loadVisibility by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = loadVisibility){
        delay(2000L)
        loadVisibility = true
        delay(1000L)
        navigator.toPage(Constants.HOME_SCREEN_ROUTE, Constants.SPLASH_SCREEN_ROUTE)
    }

    Box(modifier = modifier
        .fillMaxSize()
    ){

        Background()

        Box(modifier.align(Alignment.TopCenter).padding(vertical = 80.dp, horizontal = 20.dp)) {
            FadeText(text = "Stay Aware", delay = 500, size = 42)
        }

        AnimatedVisibility(visible = loadVisibility,
            modifier = modifier.align(Alignment.BottomCenter).padding(vertical = 80.dp, horizontal = 20.dp),
            enter = fadeIn(animationSpec = tween(durationMillis = 1000))) {
            CustomLoading(modifier = modifier
                .size(200.dp))
        }
    }
}