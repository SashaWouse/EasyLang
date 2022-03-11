package com.alexaded.easylang.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexaded.easylang.R
import com.alexaded.easylang.navigation.Screen

@Composable
fun ProgressScreenView(navController: NavController) {

    Column(modifier = Modifier
        .padding(2.dp)
        .fillMaxHeight()
        .fillMaxWidth()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        // Title
        Text(
            text = stringResource(id = R.string.progress_title),
            style = MaterialTheme.typography.h1.copy(fontSize = 20.sp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .padding(20.dp)
        )

        Button(onClick = { navController.navigate(Screen.ScanScreen.route) },
            modifier = Modifier
                .padding(10.dp)) {
            Text(
                text = stringResource(id = R.string.scan)
            )
        }

    }
}


