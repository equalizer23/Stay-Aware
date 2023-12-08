package com.news.aware.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.news.aware.R

@Composable
fun Background(modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.mipmap.bg),
        contentDescription = "Bg",
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}