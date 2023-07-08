package com.example.bubbel.CustomWidgets.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bubbel.CustomWidgets.ui.theme.ui.theme.BubbelTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.layout.layout

@Composable
fun getScreenWidth(): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp.dp
}

@Composable
fun getElementHeight(
    childComposable: @Composable () -> Unit
): Dp {
    val localDensity = LocalDensity.current
    var elementHeight
    by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.onGloballyPositioned { coordinates ->
            elementHeight = with(localDensity) { coordinates.size.height }
        }
    ) {
        childComposable()
    }
    return elementHeight.dp
}

@Composable
fun PositionedWidget(
    offsetPercentage: Dp,
    childComposable: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .offset(
                x = (-20).dp,
                y = 0.dp
            )
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset(x = offsetPercentage)
        ) {
            // Your widget content goes here
        }
    }
}

@Composable
fun Positioning(
    offsetPercentage: Float,
    childComposable: @Composable () -> Unit
    ) {
    val offset = with(LocalDensity.current) { offsetPercentage.toDp() }
    PositionedWidget(offset, childComposable)
}