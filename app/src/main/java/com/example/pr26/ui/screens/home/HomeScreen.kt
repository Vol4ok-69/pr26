package com.example.pr26.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pr26.R
import com.example.pr26.navigation.Screen
import com.example.pr26.ui.components.BottomBar
import com.example.pr26.ui.components.CategoryChip
import com.example.pr26.ui.components.ProductCard
import com.example.pr26.ui.components.SearchBar
import com.example.pr26.ui.theme.Background
import com.example.pr26.ui.theme.Primary
import com.example.pr26.ui.theme.TextPrimary
import com.example.pr26.ui.theme.TextSecondary
import com.example.pr26.viewmodel.CartViewModel
import com.example.pr26.viewmodel.FavoritesViewModel
import com.example.pr26.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel(),
    favoritesViewModel: FavoritesViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Главная",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary,
                    modifier = Modifier.testTag("home_title")
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchBar(
                    value = uiState.searchQuery,
                    onValueChange = homeViewModel::updateQuery,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Фильтр",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .background(Primary)
                        .clickable { /* reserved */ }
                        .padding(horizontal = 16.dp, vertical = 14.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(uiState.categories, key = { it.id }) { category ->
                    val selected = uiState.selectedCategory == category.title
                    CategoryChip(
                        text = category.title,
                        selected = selected,
                        onClick = { homeViewModel.selectCategory(category.title) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Популярное",
                    style = MaterialTheme.typography.titleLarge,
                    color = TextPrimary,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Смотреть все",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary,
                    modifier = Modifier.clickable { navController.navigate(Screen.Popular.route) }
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            val popularProducts = uiState.products.filter { it.isPopular }
            LazyRow(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                items(popularProducts, key = { it.id }) { product ->
                    ProductCard(
                        product = product,
                        isFavorite = favoritesViewModel.isFavorite(product.id),
                        inCart = cartViewModel.inCart(product.id),
                        onToggleFavorite = { favoritesViewModel.toggle(product.id) },
                        onAddToCart = { cartViewModel.add(product) },
                        modifier = Modifier.width(210.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Акции",
                style = MaterialTheme.typography.titleLarge,
                color = TextPrimary,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(26.dp))
                    .background(Primary.copy(alpha = 0.12f))
                    .clickable { navController.navigate(Screen.Catalog.route) }
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Outdoor",
                        style = MaterialTheme.typography.titleLarge,
                        color = TextPrimary,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Новые поступления",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }

                Image(
                    painter = painterResource(R.drawable.sneakers_1),
                    contentDescription = null,
                    modifier = Modifier.size(92.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        BottomBar(navController = navController)
    }
}
