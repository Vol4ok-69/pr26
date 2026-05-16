package com.example.pr26.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {
    val favorites = mutableStateListOf<Int>()

    fun toggle(productId: Int) {
        if (favorites.contains(productId)) favorites.remove(productId) else favorites.add(productId)
    }

    fun isFavorite(productId: Int): Boolean = favorites.contains(productId)
}

