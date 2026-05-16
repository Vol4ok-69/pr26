package com.example.pr26.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pr26.data.model.CartItem
import com.example.pr26.data.model.Product

class CartViewModel : ViewModel() {
    private val _items = mutableStateListOf<CartItem>()
    val items: List<CartItem> get() = _items

    fun add(product: Product) {
        val idx = _items.indexOfFirst { it.product.id == product.id }
        if (idx == -1) {
            _items.add(CartItem(product, 1))
        } else {
            val current = _items[idx]
            _items[idx] = current.copy(quantity = current.quantity + 1)
        }
    }

    fun remove(productId: Int) {
        _items.removeAll { it.product.id == productId }
    }

    fun increase(productId: Int) {
        val idx = _items.indexOfFirst { it.product.id == productId }
        if (idx == -1) return
        val current = _items[idx]
        _items[idx] = current.copy(quantity = current.quantity + 1)
    }

    fun decrease(productId: Int) {
        val idx = _items.indexOfFirst { it.product.id == productId }
        if (idx == -1) return
        val current = _items[idx]
        val next = current.quantity - 1
        if (next <= 0) _items.removeAt(idx) else _items[idx] = current.copy(quantity = next)
    }

    fun inCart(productId: Int): Boolean = _items.any { it.product.id == productId }

    fun totalPrice(): Double = _items.sumOf { it.product.price * it.quantity }
}

