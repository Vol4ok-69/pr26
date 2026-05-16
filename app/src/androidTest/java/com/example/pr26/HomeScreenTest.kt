package com.example.pr26

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun home_opens_from_sign_in_flow() {
        composeRule.onNodeWithText("Пропустить").performClick()
        composeRule.onNodeWithText("Привет!").assertExists()
    }
}

