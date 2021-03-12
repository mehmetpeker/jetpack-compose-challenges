package com.mehmetpeker.composechallenges.ui.screens.animation

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.mehmetpeker.composechallenges.R

@Composable
fun TurnOnTheLight(navController: NavController) {
    Scaffold {
        Column {
            TopAppBar(title = { Text(text = "Turn On The Light") }, navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            })
            Box(Modifier.fillMaxSize()) {
                BackgroundImage()
                LightCanvas()
            }
        }
    }
}

@Composable
fun BackgroundImage() {
    Card(Modifier.fillMaxSize()) {
        Image(painterResource(R.drawable.jetpack_compose), contentDescription = null)
    }
}


@Composable
fun LightCanvas() {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    var lightOn by remember { mutableStateOf(false) }
    val circleSize = Size(500f, 500f)
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        lightOn = true
                        offsetX = it.x
                        offsetY = it.y
                    }
                    MotionEvent.ACTION_MOVE -> {
                        lightOn = true
                        offsetX = it.x
                        offsetY = it.y
                    }
                    MotionEvent.ACTION_UP -> {
                        lightOn = false
                    }
                    else -> return@pointerInteropFilter false
                }
                true
            },
        onDraw =
        {
            when (lightOn) {
                true -> {
                    val circlePath = Path().apply {
                        addArc(
                            Rect(
                                Offset(
                                    offsetX - circleSize.width / 2,
                                    offsetY - circleSize.height / 2
                                ), circleSize
                            ),
                            0f,
                            360f
                        )
                    }
                    clipPath(circlePath, clipOp = ClipOp.Difference) {
                        drawRect(SolidColor(Color.Black))
                        drawPath(circlePath, SolidColor(Color.Transparent))
                    }
                }
                else -> {
                    drawRect(SolidColor(Color.Black))
                }
            }
        }
    )

}

@Preview
@Composable
fun ImagePreview() {
    BackgroundImage()
}

@Preview
@Composable
fun CanvasPreview() {
    LightCanvas()
}