package com.example.pr26

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class OnboardingTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun onboarding_navigation_skip_opens_sign_in() {
        composeRule.onNodeWithText("Пропустить").performClick()
        composeRule.onNodeWithText("Привет!").assertExists()
    }
}

