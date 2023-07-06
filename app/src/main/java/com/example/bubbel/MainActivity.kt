package com.example.bubbel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.bubbel.ui.theme.BubbelTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.unit.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("File")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubbelTheme {
        Greeting("File")
    }
}

@Composable
fun LoginScreen(){
    var xOffset = 0.1.dp
    var yOffset  = 0.1.dp

    Box(
        modifier = Modifier.offset(
            x = xOffset,
            y = yOffset
        )
    ){
        Text(
            "Login", fontSize = 25.sp)
    }
}
