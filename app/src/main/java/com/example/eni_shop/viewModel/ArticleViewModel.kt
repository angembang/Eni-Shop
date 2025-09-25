package com.example.eni_shop.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.eni_shop.model.Article
import com.example.eni_shop.model.ArticleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleViewModel(articleRepository: ArticleRepository): ViewModel() {
    private val _articles = MutableStateFlow<List<Article>>(emptyList());

    val articles : StateFlow<List<Article>> = _articles

    init {
        _articles.value = articleRepository.getArticles();
    }


    companion object {
        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return ArticleViewModel(
                    ArticleRepository()
                ) as T
            }

        }
    }

    fun AddArticle(x0: Article) {
        TODO("Not yet implemented")
    }


}