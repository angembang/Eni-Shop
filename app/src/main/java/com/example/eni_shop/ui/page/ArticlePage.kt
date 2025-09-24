package com.example.eni_shop.ui.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eni_shop.ui.page.components.ArticleCard
import com.example.eni_shop.viewModel.ArticleViewModel

@Composable
fun ArticlePage(modifier: Modifier = Modifier,
                articleViewModel: ArticleViewModel =
                    viewModel(factory = ArticleViewModel.Factory) ) {
    val articles by articleViewModel.articles.collectAsState();
    Column (modifier.fillMaxSize()){
        CategoryFilterChip();
        if(articles.isEmpty()) {
            Box(modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
                contentAlignment = Alignment.Center)
            {
                Text("Aucun article trouvé");
            }
        } else {
            LazyVerticalGrid(
                // Fix to 2 columns
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(articles) { article ->
                    ArticleCard(article, Modifier.padding(top = 16.dp))
                }
            }
    }


    }


}
