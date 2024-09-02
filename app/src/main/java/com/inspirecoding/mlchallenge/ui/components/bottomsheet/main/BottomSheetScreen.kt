package com.inspirecoding.mlchallenge.ui.components.bottomsheet.main

import androidx.compose.runtime.Composable
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.ui.components.bottomsheet.details.DetailsScreen

@Composable
fun SheetLayout(product: ResultDomain, onCloseBottomSheet: () -> Unit) {
    BottomSheetBody {
        DetailsScreen(product = product, onClickDeny = {
            onCloseBottomSheet.invoke()
        })
    }
}

@Composable
fun BottomSheetBody(content: @Composable () -> Unit) = content()