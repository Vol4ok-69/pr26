package com.example.pr26.data.fake

import com.example.pr26.R
import com.example.pr26.data.model.Category
import com.example.pr26.data.model.OnboardingItem
import com.example.pr26.data.model.Product

object FakeData {

    val onboardingItems = listOf(
        OnboardingItem(
            imageRes = R.drawable.sneakers_with_leg,
            title = "Добро пожаловать",
            description = "Лучшие кроссовки в одном приложении"
        ),
        OnboardingItem(
            imageRes = R.drawable.sneakers_2,
            title = "Выбирайте",
            description = "Популярные модели и новинки"
        ),
        OnboardingItem(
            imageRes = R.drawable.sneakers_3,
            title = "Покупайте",
            description = "Быстрое оформление заказа"
        )
    )

    val categories = listOf(
        Category(1, "Все"),
        Category(2, "Бег"),
        Category(3, "Спорт"),
        Category(4, "Повседневные"),
        Category(5, "Outdoor")
    )

    val products = listOf(
        Product(
            id = 1,
            title = "Nike Jordan",
            category = "Бег",
            price = 302.00,
            imageRes = R.drawable.sneakers_1,
            isPopular = true
        ),
        Product(
            id = 2,
            title = "Nike Air Max",
            category = "Спорт",
            price = 250.00,
            imageRes = R.drawable.sneakers_2,
            isPopular = true
        ),
        Product(
            id = 3,
            title = "Nike Club Max",
            category = "Повседневные",
            price = 180.00,
            imageRes = R.drawable.sneakers_3
        ),
        Product(
            id = 4,
            title = "Nike Air Max",
            category = "Outdoor",
            price = 280.00,
            imageRes = R.drawable.sneakers_1,
            isPopular = true
        ),
        Product(
            id = 5,
            title = "Nike Air Max",
            category = "Outdoor",
            price = 260.00,
            imageRes = R.drawable.sneakers_2
        )
    )
}

