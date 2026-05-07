package com.example.pr26.utils

import android.util.Patterns

object Validation {

    fun validateEmail(
        email: String
    ): String? {

        return when {

            email.isBlank() -> {
                "Введите электронную почту"
            }

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                "Некорректный email"
            }

            else -> null
        }
    }

    fun validatePassword(
        password: String
    ): String? {

        return when {

            password.isBlank() -> {
                "Введите пароль"
            }

            password.length < 6 -> {
                "Минимум 6 символов"
            }

            else -> null
        }
    }
}