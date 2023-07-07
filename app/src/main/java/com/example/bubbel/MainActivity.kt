package com.example.bubbel

import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.compose.material.icons.*
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextDecoration
import com.example.bubbel.*
import com.example.bubbel.ui.theme.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
            LoginInputs()
        }
    }
}



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

@Composable
fun LoginScreen(){
    Box(
        modifier = Modifier
            .width(DynamicScreenWidth(widthFactor = 1.0f))
            .background(Color(0xFF0057FF))
            .clip(MaterialTheme.shapes.medium)
    ) {
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.
                padding(33.dp, 110.dp)
        )
        Text(
            text = "Welcome back!",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .offset(33.dp, 180.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginInputs() {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .offset(0.dp, 300.dp)
            .width(375.dp)
            .height(812.dp)
    ) {
        Text(
            text = "Username",
            fontSize = 20.sp,
            fontWeight = FontWeight(450),
            color = Color(0xFF627394),
            modifier = Modifier.offset(18.dp, 0.dp)
        )
        Row(
            modifier = Modifier.offset(0.dp, 10.dp)
        ) {
            Icon(painter = painterResource(R.drawable.profile),
                contentDescription = "My Icon",
                tint = Color.Gray,
                modifier = Modifier.padding(10.dp, 7.dp)
            )
            TextField(value = username, onValueChange = {newUsername -> username = newUsername}, placeholder = { Text("Enter your username") })
        }

        Text(
            text = "Password",
            fontSize = 20.sp,
            fontWeight = FontWeight(450),
            color = Color(0xFF627394),
            modifier = Modifier.offset(18.dp, 40.dp)
        )

        Row(
            modifier = Modifier.offset(0.dp, 50.dp)
        ) {
            Icon(painter = painterResource(R.drawable.lock),
                contentDescription = "My Icon",
                tint = Color.Gray,
                modifier = Modifier.padding(10.dp, 7.dp)
            )
            TextField(
                value = password,
                onValueChange = {newPassword -> password = newPassword},
                placeholder = { Text("Enter your password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                    autoCorrect = false,
                ),
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.offset(0.dp, 50.dp),

            ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        println(username)
                        println(password)
                    },
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .width(320.dp)
                        .height(56.dp)
                ) {
                    Text(
                        text = "Log In",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(450),
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                HyperlinkText(Url = "https://github.com/", Text = "Forgot Password?", textSize = 16, horizontalOffset = 0, verticalOffset = 30)
                HyperlinkText(Url = "https://github.com/", Text = "Sign Up >", textSize = 16, horizontalOffset = 0, verticalOffset = 60)
            }
        }
    }
}

@Composable
fun HyperlinkText(Url: String, Text: String, textSize:Int, horizontalOffset:Int, verticalOffset:Int){
    val uriHandler = LocalUriHandler.current

    val annotatedString = buildAnnotatedString {
        pushStringAnnotation("URL", Url)
        withStyle(
            style = SpanStyle(
                color = Color(0xFF0057FF),
                fontSize = textSize.sp
                    )
            ) {
            append(Text)
            }
        pop()
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                uriHandler.openUri(annotation.item)
            }
        },

        modifier = Modifier
            .offset(horizontalOffset.dp, verticalOffset.dp)
    )
}