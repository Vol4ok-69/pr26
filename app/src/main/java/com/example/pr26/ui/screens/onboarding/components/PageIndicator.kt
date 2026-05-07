package com.example.pr26.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.pr26.ui.theme.Border
import com.example.pr26.ui.theme.Primary

@Composable
fun PageIndicator(
    pageCount: Int,
    currentPage: Int
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        repeat(pageCount) { index ->

            val color =
                if (index == currentPage) {
                    Primary
                } else {
                    Border
                }

            androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}