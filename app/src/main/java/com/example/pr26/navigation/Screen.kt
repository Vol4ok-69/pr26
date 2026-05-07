package com.example.pr26.navigation

sealed class Screen(val route: String) {

    data object Onboarding : Screen("onboarding")

    data object SignIn : Screen("sign_in")

    data object Home : Screen("home")

    data object Catalog : Screen("catalog")

    data object Popular : Screen("popular")

    data object Favorites : Screen("favorites")

    data object Cart : Screen("cart")

    data object Profile : Screen("profile")
}