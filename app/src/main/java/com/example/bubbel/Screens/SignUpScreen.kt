package com.example.bubbel.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.Alignment
import com.example.bubbel.CustomWidgets.ui.theme.*
import com.example.bubbel.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpView(modifier: Modifier = Modifier) {
    var username:String by remember {
        mutableStateOf("")
    }
    var password:String by remember {
        mutableStateOf("")
    }
    var email:String by remember {
        mutableStateOf("")
    }
    var confirmPassword:String by remember {
        mutableStateOf("")
    }
    BoxWithConstraints(
       modifier = Modifier
    ){
        val maxWidth = constraints.maxWidth.dp
        val isSmallScreen = maxWidth < 480.dp
        val isMediumScreen = maxWidth < 720.dp
        val isLargeScreen = maxWidth < 1080.dp

        fun DynamicPadding(
            isSmallScreen: Boolean,
            isMediumScreen: Boolean,
            isLargeScreen: Boolean,
            smallScreenPadding: Int,
            mediumScreenPadding: Int,
            largeScreenPadding: Int,
            xLargeScreenPadding: Int
        ) :Int{
            return if (isSmallScreen) {
                smallScreenPadding
            } else if (isMediumScreen) {
                mediumScreenPadding
            } else if (isLargeScreen) {
                largeScreenPadding
            } else {
                xLargeScreenPadding
            }
        }

        val xPadding =

        Box(
            modifier = Modifier
                .width(DynamicScreenWidth(widthFactor = 1.0f))
                .background(Color(0xFF0057FF))
                .clip(MaterialTheme.shapes.medium)
        ) {
            Text(
                text = "Sign Up",
                fontSize = (
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            30,
                            45,
                            60,
                            75
                        ).sp
                        ),
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.
                padding(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        50,
                        70,
                        100
                    ).dp,
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        50,
                        75,
                        100,
                        125
                    ).dp,
                )
            )
            Text(
                text = "Fill in the form to register",
                fontSize = (
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            20,
                            30,
                            35,
                            40
                        ).sp
                        ),
                color = Color.White,
                modifier = Modifier
                    .offset(
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            30,
                            50,
                            75,
                            100
                        ).dp,
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            180,
                            200,
                            220,
                            250
                        ).dp,
                    )
            )
        }
        Column(
            modifier = Modifier
                .offset(
                    0.dp,
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        270,
                        300,
                        330,
                        360
                    ).dp,
                )
                .width(
                    DynamicScreenWidth(widthFactor = 0.8f),
                )
                .height(812.dp)
        ) {
            Text(
                text = "Username",
                fontSize = DynamicPadding(
                    isSmallScreen,
                    isMediumScreen,
                    isLargeScreen,
                    20,
                    30,
                    35,
                    40
                ).sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        50,
                        70,
                        100
                    ).dp,
                    0.dp)
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
                            modifier = Modifier
                                .padding(0.dp, 7.dp)
                        )
                    },
                    modifier = Modifier
                        .width(DynamicScreenWidth(widthFactor = 0.8f))
                )
            }
            Text(
                text = "Email",
                fontSize = DynamicPadding(
                    isSmallScreen,
                    isMediumScreen,
                    isLargeScreen,
                    20,
                    30,
                    35,
                    40
                ).sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        50,
                        70,
                        100
                    ).dp,
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        10,
                        15,
                        20,
                        25
                    ).dp,
                )
            )
            Row(
                modifier = Modifier
                    .offset(0.dp, 30.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextField(
                    value = username,
                    onValueChange = {newUsername -> username = newUsername},
                    placeholder = { Text("Enter your email") },
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.profile),
                            contentDescription = "My Icon",
                            tint = Color.Gray,
                            modifier = Modifier
                                .padding(0.dp, 7.dp)
                        )
                    },
                    modifier = Modifier
                        .width(DynamicScreenWidth(widthFactor = 0.8f))
                )

                TextField(
                    value = email,
                    onValueChange = { newEmail -> email = newEmail },
                    placeholder = { Text("Enter your email") },
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.profile),
                            contentDescription = "My Icon",
                            tint = Color.Gray,
                            modifier = Modifier
                                .padding(0.dp, 7.dp)
                        )
                    },
                    modifier = Modifier
                        .width(DynamicScreenWidth(widthFactor = 0.8f))
                )
            }
            Text(
                text = "Email",
                fontSize = DynamicPadding(
                    isSmallScreen,
                    isMediumScreen,
                    isLargeScreen,
                    20,
                    30,
                    35,
                    40
                ).sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        50,
                        70,
                        100
                    ).dp,
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        10,
                        15,
                        20,
                        25
                    ).dp,
                )
            )
            Row(
                modifier = Modifier
                    .offset(0.dp, 100.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextField(
                    value = email,
                    onValueChange = { newEmail -> email = newEmail },
                    placeholder = { Text("Enter your email") },
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.profile),
                            contentDescription = "My Icon",
                            tint = Color.Gray,
                            modifier = Modifier
                                .padding(0.dp, 7.dp)
                        )
                    },
                    modifier = Modifier
                        .width(DynamicScreenWidth(widthFactor = 0.8f))
                )
            }
            Text(
                text = "Password",
                fontSize = DynamicPadding(
                    isSmallScreen,
                    isMediumScreen,
                    isLargeScreen,
                    20,
                    30,
                    35,
                    40
                ).sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        50,
                        70,
                        100
                    ).dp,
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        20,
                        35,
                        40,
                        65
                    ).dp,
                )
            )
            Row(
                modifier = Modifier
                    .offset(0.dp, 30.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextField(
                    value = password,
                    onValueChange = { newPassword -> password = newPassword },
                    placeholder = { Text("Enter your email") },
                    leadingIcon = {
                        Icon(painter = painterResource(R.drawable.profile),
                            contentDescription = "My Icon",
                            tint = Color.Gray,
                            modifier = Modifier
                                .padding(0.dp, 7.dp)
                        )
                    },
                    modifier = Modifier
                        .width(DynamicScreenWidth(widthFactor = 0.8f))
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
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "My Icon",
                    tint = Color.Gray,
                    modifier = Modifier.padding(10.dp, 7.dp)
                )
                TextField(
                    value = password,
                    onValueChange = { newPassword -> password = newPassword},
                    placeholder = { Text("Enter Password") },
                    modifier = Modifier
                        .height(40.dp))
            }
            Text(
                text = "Confirm Password",
                fontSize = 20.sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(18.dp, 60.dp)
            )
            Row(
                modifier = Modifier
                    .offset(0.dp, 70.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "My Icon",
                    tint = Color.Gray,
                    modifier = Modifier.padding(10.dp, 7.dp)
                )
                TextField(
                    value = confirmPassword,
                    onValueChange = { newConfirmPassword -> confirmPassword = newConfirmPassword },
                    placeholder = { Text("Retype password") },
                    modifier = Modifier
                        .height(40.dp)
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .offset(0.dp, 300.dp)
                .align(Alignment.Center)
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
        }
    }
}

@Composable
private fun CustomTextField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Placeholder",
    fontSize: TextUnit = typography.bodyMedium.fontSize
) {
    var text by rememberSaveable { mutableStateOf("") }
    BasicTextField(modifier = modifier
        .background(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.shapes.small,
        )
        .fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = fontSize
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) Text(
                        placeholderText,
                        style = LocalTextStyle.current.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            fontSize = fontSize
                        )
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}


