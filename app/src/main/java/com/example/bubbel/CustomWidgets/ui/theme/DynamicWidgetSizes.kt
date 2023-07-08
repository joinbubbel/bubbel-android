package com.example.bubbel.CustomWidgets.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bubbel.CustomWidgets.ui.theme.ui.theme.BubbelTheme

@Composable
fun DynamicScreenWidth(widthFactor: Float): Dp {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val shortestSide = configuration.screenHeightDp.coerceAtMost(screenWidth)
    val boardWidth = (shortestSide * widthFactor).dp
    return boardWidth
}

@Composable
fun DynamicScreenHeight(heightFactor: Float): Dp {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val shortestSide = configuration.screenWidthDp.coerceAtMost(screenHeight)
    val boardHeight = (shortestSide * heightFactor).dp
    return boardHeight
}
