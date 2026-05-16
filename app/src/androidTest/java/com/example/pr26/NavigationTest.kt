package com.example.pr26

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun bottom_navigation_works() {
        composeRule.onNodeWithText("Пропустить").performClick()
        composeRule.onNodeWithTag("email").performTextInput("test1@mail.com")
        composeRule.onNodeWithTag("password").performTextInput("123456")
        composeRule.onNodeWithTag("sign_in_btn").performScrollTo().performClick()

        var homeShown = false
        repeat(50) {
            composeRule.waitForIdle()
            try {
                composeRule.onNodeWithTag("home_title").assertExists()
                homeShown = true
                return@repeat
            } catch (_: AssertionError) {
                composeRule.mainClock.advanceTimeBy(100)
            }
        }
        if (!homeShown) {
            composeRule.onNodeWithTag("home_title").assertExists()
        }

        composeRule.onNodeWithTag("bottom_favorites").performClick()
        composeRule.onAllNodesWithText("Избранное").assertCountEquals(2)

        composeRule.onNodeWithTag("bottom_cart").performClick()
        composeRule.onAllNodesWithText("Корзина").assertCountEquals(2)

        composeRule.onNodeWithTag("bottom_profile").performClick()
        composeRule.onAllNodesWithText("Профиль").assertCountEquals(2)
    }
}
