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
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        repeat(pageCount) { idx ->
            androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .size(if (idx == currentPage) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (idx == currentPage) Primary else Border.copy(alpha = 0.6f))
            )
        }
    }
}

