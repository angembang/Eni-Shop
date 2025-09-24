package com.example.eni_shop.ui.page.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ArticleImage(url: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        AsyncImage(
            model = url,
            contentDescription = "Image article",
            modifier = modifier
                .fillMaxWidth()
                .height(250.dp)
        )
    }
}