package com.alexaded.easylang.presentation.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun MainScreenView() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = com.alexaded.easylang.R.string.app_name), fontSize = 24.sp)
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

@ExperimentalFoundationApi
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(2.dp)) {
        LazyGrid()
    }
}


@ExperimentalFoundationApi
@Composable
//fun LazyGrid(onClickStartSource : () -> Unit)
fun LazyGrid() {

    val data = listOf("Eng", "Rus", "Fin", "Fr", "Swe","Ukr")

    LazyVerticalGrid( cells = GridCells.Adaptive(160.dp), contentPadding = PaddingValues(8.dp),
        ) {
            items(6) {
                GridItemAnimation()
            }
        }
    }

@Composable
fun GridItemAnimation() {
    val animatedProgress = remember { Animatable(initialValue = -300f) }
    val opacityProgress = remember { Animatable(initialValue = 0f) }
    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 0f,
            animationSpec = tween(300, easing = LinearEasing)
        )
        opacityProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(600)
        )
    }

    val animatedModifier = Modifier
        .padding(10.dp)
        .graphicsLayer(translationX = animatedProgress.value)
        .alpha(opacityProgress.value)

    Card(
        modifier = Modifier
            .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = animatedModifier
        ) {
            Image(
                painter = painterResource(id = com.alexaded.easylang.R.drawable.ic_flag_fi_foreground),
                contentDescription = "Flag Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(85.dp)
                    .padding(2.dp)
                    .clip(CircleShape)
            )

            Text(
                text = stringResource(id = com.alexaded.easylang.R.string.card_title),
                style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                color = MaterialTheme.colors.onSecondary
            )

            Text(
                text = stringResource(id = com.alexaded.easylang.R.string.card_disc),
                style = MaterialTheme.typography.subtitle2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray
            )
        }
    }
}
