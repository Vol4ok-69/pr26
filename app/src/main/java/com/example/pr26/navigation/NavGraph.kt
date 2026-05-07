package com.example.pr26.navigation

import androidx.compose.runtime.Composable
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

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route
    ) {

        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }

        composable(Screen.SignIn.route) {
            SignInScreen(navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Catalog.route) {
            CatalogScreen(navController)
        }

        composable(Screen.Popular.route) {
            PopularScreen(navController)
        }

        composable(Screen.Favorites.route) {
            FavoritesScreen(navController)
        }

        composable(Screen.Cart.route) {
            CartScreen(navController)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
