package com.example.eni_shop.ui.router

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eni_shop.ui.page.ArticleDetail
import com.example.eni_shop.ui.page.ArticleForm
import com.example.eni_shop.ui.page.ArticlePage
import com.example.eni_shop.viewModel.ArticleViewModel

@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navHostController : NavHostController = rememberNavController(),
               articleViewModel: ArticleViewModel = viewModel(factory = ArticleViewModel.Factory)
               ) {
    val articles by articleViewModel.articles.collectAsState()
    NavHost(
        navController = navHostController,
        startDestination = "articles",
        modifier = modifier
    ) {
        // List of article
        composable("articles") {
            ArticlePage(onClickArticle =  {
                article ->
                navHostController.navigate("detail/${article.id}")
            },
                onSave = {
                    navHostController.navigate("add")
                })

        }

        // Detail article route
        composable("detail/{articleId}") {
            backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId")?.toIntOrNull()
            val article = articles.find { it.id == articleId }

            if (article != null) {
                ArticleDetail(article = article, navController = navHostController)
            } else {
                Text("Article non trouvé")
            }

        }

        // Add article route
        composable("add") {
            ArticleForm(
                onSave = {
                    article ->navHostController.navigate("articles")
                }
            )


        }
    }
}