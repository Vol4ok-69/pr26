package com.example.pr26.data.repository

import com.example.pr26.data.fake.FakeData
import com.example.pr26.data.model.Category
import com.example.pr26.data.model.Product

class ProductRepository {

    fun getCategories(): List<Category> = FakeData.categories

    fun getProducts(): List<Product> = FakeData.products
}

