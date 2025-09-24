package com.example.eni_shop.model

class CategoryRepository {
    private val _categories = listOf("electronics","jewelery","men's clothing","women's clothing");

    // Method to get all categories
    fun getCategories(): List<String> {
        return _categories

    }
}