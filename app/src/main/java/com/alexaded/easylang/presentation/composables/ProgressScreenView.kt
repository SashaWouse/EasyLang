package com.alexaded.easylang.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexaded.easylang.R


@Preview(showBackground = true)
@Composable
fun ProgressScreenView() {

    Column(modifier = Modifier.padding(2.dp)) {

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

        Button(onClick = { /*TODO Call Recognition Screen*/ },
            modifier = Modifier
                .padding(10.dp)) {
            Text(
                text = stringResource(id = R.string.scan)
            )
        }

    }
}


