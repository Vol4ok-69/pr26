package com.example.pr26.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pr26.data.model.Category
import com.example.pr26.data.model.Product
import com.example.pr26.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class CatalogUiState(
    val title: String = "Outdoor",
    val categories: List<Category> = emptyList(),
    val products: List<Product> = emptyList(),
    val selectedCategory: String = "Все"
)

class CatalogViewModel(
    private val repo: ProductRepository = ProductRepository()
) : ViewModel() {

    val selectedCategories = mutableStateListOf<String>()

    private val _uiState = MutableStateFlow(
        CatalogUiState(
            categories = repo.getCategories(),
            products = repo.getProducts()
        )
    )
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    fun selectCategory(category: String) {
        selectedCategories.clear()
        selectedCategories.add(category)

        _uiState.value = _uiState.value.copy(selectedCategory = category)
    }
}

