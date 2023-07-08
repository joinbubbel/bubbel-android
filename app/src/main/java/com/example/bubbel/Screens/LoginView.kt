package com.example.bubbel.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bubbel.CustomWidgets.ui.theme.*
import com.example.bubbel.R
import com.example.bubbel.Screens.ui.theme.BubbelTheme

@Composable
fun LoginScreen(){
    Box {
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
        LoginInputs()
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
            modifier = Modifier
                .offset(0.dp, 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            TextField(
                value = username,
                onValueChange = {newUsername -> username = newUsername},
                placeholder = { Text("Enter your username") },
                leadingIcon = {
                    Icon(painter = painterResource(R.drawable.profile),
                        contentDescription = "My Icon",
                        tint = Color.Gray,
                        modifier = Modifier.padding(0.dp, 7.dp)
                    )
                }
            )
        }

        Text(
            text = "Password",
            fontSize = 20.sp,
            fontWeight = FontWeight(450),
            color = Color(0xFF627394),
            modifier = Modifier.offset(18.dp, 40.dp)
        )

        Row(
            modifier = Modifier
                .offset(0.dp, 50.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            TextField(
                value = password,
                onValueChange = {newPassword -> password = newPassword},
                leadingIcon = {
                    Icon(painter = painterResource(R.drawable.lock),
                        contentDescription = "My Icon",
                        tint = Color.Gray,
                        modifier = Modifier.padding(10.dp, 7.dp)
                    )
                },
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
                    colors = ButtonDefaults.buttonColors(Color(0xFF0057FF)),
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
                            color = Color.White,
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


