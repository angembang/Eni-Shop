package com.example.eni_shop.viewModel

import android.content.Intent
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.eni_shop.model.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CategoryViewModel(categoryRepository: CategoryRepository): ViewModel() {
    private val _categories = MutableStateFlow<List<String>>(emptyList());
    val categories : StateFlow<List<String>> = _categories

    init {
        _categories.value = categoryRepository.getCategories();
    }


    companion object {
        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return CategoryViewModel(
                    CategoryRepository()
                ) as T
            }

        }
    }
}

