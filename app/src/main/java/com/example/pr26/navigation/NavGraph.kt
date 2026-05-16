package com.example.pr26.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pr26.ui.screens.auth.SignInScreen
import com.example.pr26.ui.screens.cart.CartScreen
import com.example.pr26.ui.screens.catalog.CatalogScreen
import com.example.pr26.ui.screens.favorites.FavoritesScreen
import com.example.pr26.ui.screens.home.HomeScreen
import com.example.pr26.ui.screens.onboarding.OnboardingScreen
import com.example.pr26.ui.screens.popular.PopularScreen
import com.example.pr26.ui.screens.profile.ProfileScreen
import com.example.pr26.viewmodel.AuthViewModel
import com.example.pr26.viewmodel.CartViewModel
import com.example.pr26.viewmodel.CatalogViewModel
import com.example.pr26.viewmodel.FavoritesViewModel
import com.example.pr26.viewmodel.HomeViewModel
import com.example.pr26.viewmodel.ProfileViewModel

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    val authViewModel: AuthViewModel = viewModel()
    val favoritesViewModel: FavoritesViewModel = viewModel()
    val cartViewModel: CartViewModel = viewModel()
    val homeViewModel: HomeViewModel = viewModel()
    val catalogViewModel: CatalogViewModel = viewModel()
    val profileViewModel: ProfileViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route
    ) {

        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }

        composable(Screen.SignIn.route) {
            SignInScreen(navController, authViewModel)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController, homeViewModel, favoritesViewModel, cartViewModel)
        }

        composable(Screen.Catalog.route) {
            CatalogScreen(navController, catalogViewModel, favoritesViewModel, cartViewModel)
        }

        composable(Screen.Popular.route) {
            PopularScreen(navController, favoritesViewModel, cartViewModel)
        }

        composable(Screen.Favorites.route) {
            FavoritesScreen(navController, favoritesViewModel, cartViewModel)
        }

        composable(Screen.Cart.route) {
            CartScreen(navController, cartViewModel)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController, authViewModel, profileViewModel)
        }
    }
}
