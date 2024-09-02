package com.inspirecoding.mlchallenge.ui.components.chip

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem
import com.inspirecoding.mlchallenge.ui.theme.color.YellowMain
import com.inspirecoding.mlchallenge.ui.theme.type.Typography

@Composable
fun Chip(
    text: String,
    isSelected: Boolean = false,
    item: CategoriesDomainItem,
    onSelectionChanged: (CategoriesDomainItem) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onSelectionChanged(item)
            },
        shape = RoundedCornerShape(100.dp),
        color = if (isSelected) YellowMain else Color.White.copy(alpha = 0.6f)
    ) {
        Text(
            modifier = Modifier.padding(start = 14.dp, end = 14.dp, top = 8.dp, bottom = 10.dp),
            text = text.lowercase(),
            style = Typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color.Black else Color.DarkGray
        )
    }
}