package com.example.pr26.ui.screens.popular

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pr26.data.fake.FakeData
import com.example.pr26.ui.components.ProductGrid
import com.example.pr26.ui.theme.Background
import com.example.pr26.ui.theme.TextPrimary
import com.example.pr26.viewmodel.CartViewModel
import com.example.pr26.viewmodel.FavoritesViewModel

@Composable
fun PopularScreen(
    navController: NavController,
    favoritesViewModel: FavoritesViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val products = FakeData.products.filter { it.isPopular }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .safeDrawingPadding()
            .padding(horizontal = 18.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Назад",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Популярное",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        ProductGrid(
            products = products,
            isFavorite = favoritesViewModel::isFavorite,
            inCart = cartViewModel::inCart,
            onToggleFavorite = favoritesViewModel::toggle,
            onAddToCart = cartViewModel::add,
            modifier = Modifier.weight(1f)
        )
    }
}

