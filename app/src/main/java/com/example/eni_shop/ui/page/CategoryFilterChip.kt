package com.example.eni_shop.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eni_shop.model.Category
import com.example.eni_shop.viewModel.CategoryViewModel
import kotlin.collections.set

@Composable
fun CategoryFilterChip(
    modifier: Modifier = Modifier,
    categoryViewModel: CategoryViewModel = viewModel(factory = CategoryViewModel.Factory),
    onSelectCategory : (categoriesName : List<String>)->Unit
) {
    val categories by categoryViewModel.categories.collectAsState()
    val selectedStates = remember { mutableStateMapOf<Category, Boolean>() }

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            val selected = selectedStates[category] ?: false

            FilterChip(
                onClick = {
                    selectedStates[category] = !selected
                    // we retrieved selected categories, filtrated the selected categories by it value (true),
                    // we retrieved only the key of the map(Category)
                    // and retrieved only the key (object) name
                    // Ex. return the list of categories names selected
                    onSelectCategory(selectedStates.filter { it.value }.keys.toList().map { it.name })
                },
                label = { Text(category.name) },
                selected = selected,
                leadingIcon = if (selected) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Selected",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else null

            )
        }
    }

}




