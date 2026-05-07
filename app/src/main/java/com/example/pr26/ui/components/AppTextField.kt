package com.example.pr26.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    error: String? = null
) {

    OutlinedTextField(
        value = value,

        onValueChange = onValueChange,

        label = {
            Text(text = label)
        },

        singleLine = true,

        isError = error != null,

        modifier = Modifier
            .fillMaxWidth()
    )

    if (error != null) {

        Text(
            text = error,

            modifier = Modifier.padding(
                top = 4.dp,
                start = 4.dp
            )
        )
    }
}