package com.example.pr26.ui.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pr26.data.fake.FakeData
import com.example.pr26.ui.components.BottomBar
import com.example.pr26.ui.components.EmptyState
import com.example.pr26.ui.components.ProductGrid
import com.example.pr26.ui.theme.Background
import com.example.pr26.ui.theme.TextPrimary
import com.example.pr26.viewmodel.CartViewModel
import com.example.pr26.viewmodel.FavoritesViewModel

@Composable
fun FavoritesScreen(
    navController: NavController,
    favoritesViewModel: FavoritesViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val favorites = favoritesViewModel.favorites.toSet()
    val products = FakeData.products.filter { favorites.contains(it.id) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Избранное",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (products.isEmpty()) {
                EmptyState(text = "Нет избранных товаров")
            } else {
                ProductGrid(
                    products = products,
                    isFavorite = favoritesViewModel::isFavorite,
                    inCart = cartViewModel::inCart,
                    onToggleFavorite = favoritesViewModel::toggle,
                    onAddToCart = cartViewModel::add,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        BottomBar(navController = navController)
    }
}

