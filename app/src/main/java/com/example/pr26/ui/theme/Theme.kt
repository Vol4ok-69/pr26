package com.example.pr26.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AppColorScheme = lightColorScheme(

    primary = Primary,

    secondary = Secondary,

    background = Background,

    surface = White,

    onPrimary = White,

    onBackground = TextPrimary,

    onSurface = TextPrimary,

    error = Error
)

@Composable
fun Pr26Theme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}