package com.inspirecoding.mlchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem

@Composable
fun ChipGroup(
    category: CategoriesDomainItem?,
    list: List<CategoriesDomainItem>,
    onSelectionChanged: (CategoriesDomainItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(list) { item ->
            item.name?.let {
                Chip(
                    text = it,
                    item = item,
                    isSelected = category?.id == item.id,
                    onSelectionChanged =  { selected ->
                        onSelectionChanged.invoke(selected)
                    }
                )
            }
        }
    }
}