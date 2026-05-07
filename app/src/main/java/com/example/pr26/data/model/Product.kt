package com.example.pr26.data.model

data class Product(

    val id: Int,

    val title: String,

    val category: String,

    val price: Double,

    val imageRes: Int,

    val isPopular: Boolean = false
)