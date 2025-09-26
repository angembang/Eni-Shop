package com.example.eni_shop.model

class CategoryRepository {
    private val _categories = listOf<Category>(
        Category(1,
            "electronics"),

        Category(2,
            "jewelery"),

        Category(
            3,
            "men's clothing"),

        Category(
            4,
            "women's clothing")
    )

    // Method to get all categories
    fun getCategories(): List<Category> {
        return _categories

    }
}