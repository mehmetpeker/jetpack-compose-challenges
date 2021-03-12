package com.mehmetpeker.composechallenges.ui.screens.animation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.mehmetpeker.composechallenges.utils.Constants

@Composable
fun SampleList(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Jetpack Compose Samples") })
        }
    ) {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                ListItem(text = "Turn On The Light") {
                   navController.navigate(Constants .SCREEN_TURN_ON_THE_LIGHT)
                }
            }

        }
    }
}

@Composable
fun ListItem(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(modifier = modifier, onClick = { onClick() }) {
        Text(text)
    }
}
@Composable
@Preview
fun ListItemPreview(){
    ListItem(text = "Jetpack Compose") {
    }
}
