package com.example.eni_shop.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.eni_shop.model.Article
import com.example.eni_shop.ui.page.components.ArticleImage
import java.text.SimpleDateFormat
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetail(article: Article,
                  modifier: Modifier = Modifier
) {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    val isFavorite = true;

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),

                title = { Text(
                    article.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            item {
                // Image
                ArticleImage(url = article.urlImage)

                Spacer(modifier = Modifier.height(16.dp))

                // Description
                Text(
                    text = article.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                // ARTICLE Category
                Text(
                    text = "Catégorie : ${article.category}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))


                // price and date
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Prix : ${article.price} €",
                        style = MaterialTheme.typography.bodyLarge,

                        )
                    Text(
                        text = "Date de sortie : ${formatter.format(article.dateArticle)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                // Checkbox Favorite
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment =  Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isFavorite,
                        onCheckedChange = {"$isFavorite = false"},
                    )
                    Text(text = "Favoris ?")
                }
            }
        }
    }
}




