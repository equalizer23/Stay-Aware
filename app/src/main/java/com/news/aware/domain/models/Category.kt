package com.news.aware.domain.models



import androidx.compose.material.icons.Icons

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Category(
    val name: String
){
     data object AI: Category(
         "AI"
     )

    data object Ukraine: Category(
        "Ukraine"
    )

    data object Tesla: Category(
        "Tesla"
    )

    data object Apple: Category(
        "Apple"
    )

    data object Israel: Category(
        "Israel"
    )
}
