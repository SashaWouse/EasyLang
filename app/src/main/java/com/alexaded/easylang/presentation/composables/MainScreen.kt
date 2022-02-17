package com.alexaded.easylang.presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun MainScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
//                    Text(text = stringResource(R.string.app_name), fontSize = 24.sp)
                    Text(text = "EasyLang", fontSize = 24.sp)
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(2.dp)) {
        LazyGrid()
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyGrid(onClickStartSource : () -> Unit) {

    val data = listOf("Lang 1", "Lang 2", "Lang 3", "Lang 4", "Lang 5")

    LazyVerticalGrid(
        cells = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(data.size) { item ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),elevation = 8.dp,
                backgroundColor = androidx.compose.ui.graphics.Color.Gray,
                onClick = {onClickStartSource}
            ) {
                // Some img
            }
        }
    }
}
