package com.example.eni_shop.model

import java.util.Date

class Article(
    val id: Int,
    val name: String,
    val description: String,
    val price: Float,
    val urlImage: String,
    val category: String,
    val dateArticle: Date
)