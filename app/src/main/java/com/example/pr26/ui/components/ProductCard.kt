package com.example.pr26.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pr26.R
import com.example.pr26.data.model.Product
import com.example.pr26.ui.theme.CardBackground
import com.example.pr26.ui.theme.Primary
import com.example.pr26.ui.theme.TextPrimary
import com.example.pr26.ui.theme.TextSecondary

@Composable
fun ProductCard(
    product: Product,
    isFavorite: Boolean,
    inCart: Boolean,
    onToggleFavorite: () -> Unit,
    onAddToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .background(CardBackground)
            .padding(14.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(Color(0xFFF6F6F6))
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(product.imageRes),
                contentDescription = product.title,
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(92.dp)
            )

            Image(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Избранное",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(22.dp)
                    .clip(RoundedCornerShape(11.dp))
                    .background(if (isFavorite) Primary.copy(alpha = 0.18f) else Color.Transparent)
                    .clickable(onClick = onToggleFavorite)
                    .padding(3.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = product.title,
            style = MaterialTheme.typography.titleMedium,
            color = TextPrimary,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = product.category,
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${product.price.toInt()} ₽",
                style = MaterialTheme.typography.titleMedium,
                color = TextPrimary,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.weight(1f))

            val icon = if (inCart) R.drawable.icon_in_cart_for_product_card else R.drawable.icon_add_to_cart_for_product_card
            Image(
                painter = painterResource(icon),
                contentDescription = if (inCart) "В корзине" else "Добавить в корзину",
                modifier = Modifier
                    .size(28.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable(enabled = !inCart, onClick = onAddToCart)
            )
        }
    }
}

