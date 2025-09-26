package com.example.eni_shop.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eni_shop.model.Article
import com.example.eni_shop.ui.page.components.ArticleCard
import com.example.eni_shop.viewModel.ArticleViewModel

@Composable
fun ArticlePage(
    modifier: Modifier = Modifier,
    articleViewModel: ArticleViewModel =
        viewModel(factory = ArticleViewModel.Factory),
    onClickArticle: (article: Article) -> Unit,
    onSave: () -> Unit,
) {
    val articles by articleViewModel.articles.collectAsState();
    Column (modifier.fillMaxSize()){
        CategoryFilterChip(modifier = Modifier.padding(top = 16.dp),
            onSelectCategory = {
                selectedCategories -> articleViewModel.filterArticles(selectedCategories)
            });
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
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxWidth(),

            ) {
                items(articles) { article ->
                    ArticleCard(

                        article = article,
                        Modifier.size(250.dp)
                    ) { onClickArticle(article) }

                }


            }

        }

        // Button to add an article
        Button(
            onClick = { onSave() },
            modifier.fillMaxWidth()
                .padding( 16.dp)
        )
        {
            Text("Ajouter un article",
                )
        }

    }

}
