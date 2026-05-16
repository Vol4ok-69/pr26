package com.example.pr26.navigation

import androidx.annotation.DrawableRes
import com.example.pr26.R

data class BottomNavItem(
    val screen: Screen,
    @DrawableRes val iconRes: Int,
    val label: String
) {
    companion object {
        val items = listOf(
            BottomNavItem(Screen.Home, R.drawable.home, "Главная"),
            BottomNavItem(Screen.Favorites, R.drawable.heart, "Избранное"),
            BottomNavItem(Screen.Cart, R.drawable.cart, "Корзина"),
            BottomNavItem(Screen.Profile, R.drawable.profile, "Профиль")
        )
    }
}

