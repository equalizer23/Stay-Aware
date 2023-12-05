package com.news.aware.ui.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign

@Composable
fun FadeText(text: String, delay: Int, size: Int, align: TextAlign = TextAlign.Center) {
    val alpha by animateFloatAsState(
        targetValue = 1f,
        label = "Fade In",
        animationSpec = tween(1000, easing = LinearOutSlowInEasing, delayMillis = delay)
    )

    CoolText(text = text, size = size, align = align, modifier = Modifier.alpha(alpha))

}