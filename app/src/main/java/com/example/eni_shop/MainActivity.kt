package com.example.eni_shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eni_shop.ui.page.ArticlePage
import com.example.eni_shop.ui.page.CategoryFilterChip
import com.example.eni_shop.ui.page.components.TopAppBar
import com.example.eni_shop.ui.theme.ENIShopTheme
import com.example.eni_shop.viewModel.ArticleViewModel


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ENIShopTheme {
                //val articleViewModel: ArticleViewModel = viewModel()
                val  articleViewModel: ArticleViewModel =
                    viewModel(factory = ArticleViewModel.Factory)
                val articles by articleViewModel.articles.collectAsState()

                Scaffold(
                    topBar = {TopAppBar()},
                    modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    // Form
                    /*ArticleForm(
                        Modifier.padding(innerPadding),
                        onSave = { article ->
                            articleViewModel.AddArticle(article)
                        },

                    )*/

                    // List of articles
                    ArticlePage(Modifier.padding(innerPadding))


                    /*ArticleDetail(
                        article = article,
                        Modifier.padding(innerPadding))
                    ArticleForm(Modifier.padding(innerPadding))*/


                    //GoogleSearch(Modifier.padding(innerPadding))

                }
            }
        }
    }
}



// Google search
/*@Composable
fun GoogleSearch(modifier: Modifier = Modifier,
                 categoryViewModel: CategoryViewModel = viewModel(factory = CategoryViewModel.Factory),
                 articleViewModel: ArticleViewModel =
                     viewModel(factory = ArticleViewModel.Factory)) {
    val context = LocalContext.current;
    val categories by categoryViewModel.categories.collectAsState()
    categories.forEach { category ->
        Button(onClick = {
            Intent(Intent.ACTION_VIEW, "https://www.google.com/search?q=${category}".toUri()).also {
                context.startActivity(it)
            }


        }) {
            Text(category)
        }
    }



}*/






