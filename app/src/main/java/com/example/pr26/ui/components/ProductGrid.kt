package com.example.pr26.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pr26.data.model.Product

@Composable
fun ProductGrid(
    products: List<Product>,
    isFavorite: (Int) -> Boolean,
    inCart: (Int) -> Boolean,
    onToggleFavorite: (Int) -> Unit,
    onAddToCart: (Product) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxWidth(),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(products, key = { it.id }) { product ->
            ProductCard(
                product = product,
                isFavorite = isFavorite(product.id),
                inCart = inCart(product.id),
                onToggleFavorite = { onToggleFavorite(product.id) },
                onAddToCart = { onAddToCart(product) }
            )
        }
    }
}

