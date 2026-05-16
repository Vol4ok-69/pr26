package com.example.pr26

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class LoginTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun successful_login_opens_home() {
        composeRule.onNodeWithText("Пропустить").performClick()

        composeRule.onNodeWithTag("email").performTextClearance()
        composeRule.onNodeWithTag("email").performTextInput("test1@mail.com")
        composeRule.onNodeWithTag("password").performTextClearance()
        composeRule.onNodeWithTag("password").performTextInput("123456")
        composeRule.onNodeWithTag("sign_in_btn").performScrollTo().performClick()

        // Wait for async sign-in + navigation.
        repeat(50) {
            composeRule.waitForIdle()
            try {
                composeRule.onNodeWithTag("home_title").assertExists()
                return
            } catch (_: AssertionError) {
                composeRule.mainClock.advanceTimeBy(100)
            }
        }

        composeRule.onNodeWithTag("home_title").assertExists()
    }
}
