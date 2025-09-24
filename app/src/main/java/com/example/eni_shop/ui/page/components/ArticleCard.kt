package com.example.eni_shop.ui.page.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.eni_shop.model.Article

@SuppressLint("NotConstructor")
@Composable
fun ArticleCard(article: Article, modifier: Modifier = Modifier) {
    Card (
        modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ){
        Column(modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = article.urlImage,
                contentDescription = article.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(article.name,
                style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
            Text("${article.price} €", style = MaterialTheme.typography.bodySmall)
        }
    }

}
