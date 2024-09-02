package com.inspirecoding.mlchallenge.ui.components.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.inspirecoding.mlchallenge.R
import com.inspirecoding.mlchallenge.ui.theme.color.BackgroundColor
import com.inspirecoding.mlchallenge.ui.theme.color.YellowMain
import com.inspirecoding.mlchallenge.ui.components.text.CustomTextField
import com.inspirecoding.mlchallenge.utils.Constants.Text.EMPTY_STRING_DEFAULT

@Composable
fun SearchToolbar(
    modifier: Modifier = Modifier,
    goBack: Boolean = true,
    onSearchClick: () -> Unit = {},
    searchToolbarText: String = EMPTY_STRING_DEFAULT,
    searchText: String = EMPTY_STRING_DEFAULT,
    onNavigateUpClick: () -> Unit = {},
    onTextChanged: (String) -> Unit,
    content: @Composable () -> Unit,
    contentBottom: @Composable () -> Unit = {},
) {
    Scaffold(
        topBar = {
            ToolbarSearch(
                title = searchToolbarText,
                onBackPressed = {
                    onNavigateUpClick.invoke()
                })
        },
        containerColor = BackgroundColor,
        bottomBar = contentBottom,
        content = { values ->
            val hasSearch = remember { mutableStateOf(false) }

            Column(modifier = Modifier.padding(values)) {
                CustomTextField(
                    modifier = modifier
                        .padding(bottom = 5.dp)
                        .background(YellowMain),
                    text = searchText,
                    hintText = stringResource(id = R.string.ml_challenge_search_product),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ml_challenge_ic_search),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    },
                    trailingIcon = { searchText, handler ->
                        searchText as String
                        if (searchText.isNotBlank()) {
                            Icon(
                                painter = painterResource(id = R.drawable.ml_challenge_ic_clear_field),
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    handler?.invoke()
                                }
                            )
                        }
                    },
                    onTextChange = {
                        hasSearch.value = it.isNotBlank()
                        onTextChanged(it)
                    },
                    onSearchClick = {
                        onSearchClick()
                    },
                    onClick = {
                        if (goBack) onNavigateUpClick.invoke()
                    }
                )
                content()
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarSearch(
    modifier: Modifier = Modifier,
    title: String? = null,
    onBackPressed: (() -> Unit)? = null
) {
    TopAppBar(
        modifier = modifier,
        title = {
            if (!title.isNullOrEmpty()) {
                Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis)
            } else {
                Image(
                    modifier = Modifier
                        .size(54.dp)
                        .background(Color.Transparent),
                    painter = rememberAsyncImagePainter(R.drawable.logo_ml),
                    contentScale = ContentScale.Fit,
                    contentDescription = null
                )
            }
        },
        navigationIcon = {
            if (onBackPressed != null) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.ml_challenge_content_accessibility_back)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = YellowMain,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black
        )
    )
}