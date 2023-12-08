package com.news.aware.ui.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.news.aware.domain.models.Category

@Composable
fun CategoryItem(category: Category) {
    Box(modifier = Modifier
        .width(100.dp)
        .height(50.dp)
        .padding(end = 8.dp)
    ){
        OutlinedCard(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(8.dp),
            border = BorderStroke(2.dp, color = Color.Black)
        ) {
                Box(modifier = Modifier.fillMaxSize()){
                    CoolText(text = category.name, size = 18, modifier = Modifier.align(Alignment.Center))
                }
        }
    }
}