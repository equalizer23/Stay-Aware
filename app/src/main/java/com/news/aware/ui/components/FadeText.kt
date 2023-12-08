package com.news.aware.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.delay

@Composable
fun FadeText(text: String, delay: Long, size: Int, align: TextAlign = TextAlign.Center) {
    var visibility by remember{ mutableStateOf(false) }

    LaunchedEffect(key1 = visibility){
        delay(delay)
        visibility = true
    }

    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000))
    ) {
        CoolText(text = text, size = size, align = align)
    }

}