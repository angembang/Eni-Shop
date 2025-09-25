package com.example.eni_shop.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eni_shop.model.Article
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleForm (
    modifier: Modifier = Modifier,
    // callback to the ViewModel
    onSave: (Article) -> Unit) {
    var title by remember {mutableStateOf("")};
    var  description by remember {mutableStateOf("")};
    var price by remember { mutableStateOf("")};
    // List of categories
    val categories = listOf("electronics","jewelery","men's clothing","women's clothing")
    // Open/close menu state
    var expanded by remember { mutableStateOf(false) }
    // Selected element status
    var selectedCategory by remember { mutableStateOf("") }

    Column ( modifier = modifier){
        TextField(title, onValueChange = {title = it}, label = {Text("Titre")}, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))
        TextField(description, onValueChange = {description = it}, label = {Text("Description")}, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))
        TextField(price, onValueChange = { it -> price = it.filter { it.isDigit() }}, label = {Text("Prix")}, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))

        // Categories
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedCategory,
                onValueChange = {},
                readOnly = true,
                label = { Text("Categories") },
                placeholder = {Text("Choisir une catégorie")},
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                categories.forEach { category ->
                    DropdownMenuItem(
                        text = { Text(category) },
                        onClick = {
                            selectedCategory = category
                            expanded = false
                        }
                    )
                }
            }
        }
        Button(onClick = {
            val price = price.toFloatOrNull() ?: 0f
            val article = Article(
                id = (0..1000).random(),
                name = title,
                description = description,
                price = price,
                urlImage = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                category = selectedCategory,
                dateArticle = Date()
            )
            onSave(article)
            // reset form
            title = ""
            description = ""
            //price = ""
            selectedCategory = "men's clothing"
        },
            modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            Text(
                "Enregistrer",
                //color = Color.White,
            )
        }
    }

}