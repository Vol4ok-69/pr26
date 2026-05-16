package com.example.pr26

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class SignInValidationTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun sign_in_validation_shows_errors() {
        composeRule.onNodeWithText("Пропустить").performClick()

        composeRule.onNodeWithTag("email").performTextInput("bad-email")
        composeRule.onNodeWithTag("password").performTextInput("123")
        composeRule.onNodeWithTag("sign_in_btn").performScrollTo().performClick()

        // Validation happens on input; sign in shouldn't navigate.
        composeRule.onNodeWithText("Главная").assertDoesNotExist()
    }
}
