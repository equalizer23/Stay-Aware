package com.news.aware.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.news.aware.R

@Composable
fun CoolText(modifier: Modifier = Modifier, text: String, align: TextAlign = TextAlign.Center, size: Int) {
    Text(
        modifier = modifier,
        text = text,
        color = Color.Black,
        fontSize = size.sp,
        fontFamily = FontFamily(Font(R.font.notosans_regular)),
        textAlign = align
    )
}