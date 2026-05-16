package com.example.pr26.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pr26.data.model.Category
import com.example.pr26.data.model.Product
import com.example.pr26.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeUiState(
    val title: String = "Главная",
    val searchQuery: String = "",
    val categories: List<Category> = emptyList(),
    val products: List<Product> = emptyList(),
    val selectedCategory: String = "Все"
)

class HomeViewModel(
    private val repo: ProductRepository = ProductRepository()
) : ViewModel() {

    val selectedCategories = mutableStateListOf<String>()

    private val _uiState = MutableStateFlow(
        HomeUiState(
            categories = repo.getCategories(),
            products = repo.getProducts()
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun updateQuery(value: String) {
        _uiState.value = _uiState.value.copy(searchQuery = value)
    }

    fun selectCategory(category: String) {
        selectedCategories.clear()
        selectedCategories.add(category)
        _uiState.value = _uiState.value.copy(selectedCategory = category)
    }
}

