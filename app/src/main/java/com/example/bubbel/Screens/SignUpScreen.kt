package com.example.bubbel.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.LocalConfiguration
import com.example.bubbel.CustomWidgets.ui.theme.*
import com.example.bubbel.R
import com.example.bubbel.CustomWidgets.ui.theme.DynamicPadding
import kotlinx.serialization.json.Json.Default.configuration


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpView(modifier: Modifier = Modifier) {
    var username: String by remember {
        mutableStateOf("")
    }
    var password: String by remember {
        mutableStateOf("")
    }
    var email: String by remember {
        mutableStateOf("")
    }
    var confirmPassword: String by remember {
        mutableStateOf("")
    }
    BoxWithConstraints(
        modifier = Modifier
    ) {
        val configuration = LocalConfiguration.current
        val maxWidth = configuration.screenWidthDp.dp
        val isSmallScreen = maxWidth < 360.dp
        val isMediumScreen = 360.dp < maxWidth && maxWidth < 480.dp
        val isLargeScreen = 480.dp < maxWidth && maxWidth < 600.dp


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
                                20,
                                30,
                                50,
                                60
                            ).sp
                            ),
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.padding(
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            20,
                            30,
                            40,
                            50

                        ).dp,
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            70,
                            90,
                            110,
                            130
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
                                15,
                                20,
                                25,
                                30
                            ).sp
                            ),
                    color = Color.White,
                    modifier = Modifier
                        .offset(
                            DynamicPadding(
                                isSmallScreen,
                                isMediumScreen,
                                isLargeScreen,
                                20,
                                30,
                                40,
                                50
                            ).dp,
                            DynamicPadding(
                                isSmallScreen,
                                isMediumScreen,
                                isLargeScreen,
                                120,
                                150,
                                180,
                                210
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
                        200,
                        240,
                        300,
                        330
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
                    10,
                    15,
                    20,
                   25
                ).sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        40,
                        50,
                        70
                    ).dp,
                    0.dp
                )
            )
            Row(
                modifier = Modifier
                    .offset(
                        0.dp,
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            5,
                            10,
                            15,
                            20
                        ).dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {

                TextField(
                    value = username,
                    onValueChange = { newUsername -> username = newUsername },
                    placeholder = { Text("Enter your username") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.profile),
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
                text = "Email Address",
                fontSize = DynamicPadding(
                    isSmallScreen,
                    isMediumScreen,
                    isLargeScreen,
                    10,
                    15,
                    20,
                    25
                ).sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        40,
                        50,
                        60
                    ).dp,
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        15,
                        20,
                        25,
                        30
                    ).dp,
                )
            )
            Row(
                modifier = Modifier
                    .offset(
                        0.dp,
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            20,
                            30,
                            40,
                            50
                        ).dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextField(
                    value = email,
                    onValueChange = { newEmail -> email = newEmail },
                    placeholder = { Text("Enter your email") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = "My Icon",
                            tint = Color.Gray,
                            modifier = Modifier.padding(0.dp, 7.dp)
                        )
                    },
                    modifier = Modifier
                        .width(DynamicScreenWidth(widthFactor = 0.8f))
                        .fillMaxWidth()
                )
            }
            Text(
                text = "Password",
                fontSize = DynamicPadding(
                    isSmallScreen,
                    isMediumScreen,
                    isLargeScreen,
                    10,
                    15,
                    20,
                    25
                ).sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        40,
                        50,
                        60
                    ).dp,
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        40,
                        50,
                        60
                    ).dp,
                )
            )
            Column(
                modifier = Modifier
                    .offset(
                        0.dp,
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            40,
                            50,
                            60,
                            70
                        ).dp
                    )
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally
                ,
            ) {
                TextField(
                    value = password,
                    onValueChange = { newPassword -> password = newPassword},
                    placeholder = { Text("Enter your Password") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.profile),
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
                text = "Confirm Password",
                fontSize = DynamicPadding(
                    isSmallScreen,
                    isMediumScreen,
                    isLargeScreen,
                    10,
                    15,
                    20,
                    25
                ).sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF627394),
                modifier = Modifier.offset(
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        30,
                        40,
                        50,
                        60
                    ).dp,
                    DynamicPadding(
                        isSmallScreen,
                        isMediumScreen,
                        isLargeScreen,
                        50,
                        60,
                        70,
                        80
                    ).dp,
                )
            )
            Row(
                modifier = Modifier
                    .offset(
                        0.dp,
                        DynamicPadding(
                            isSmallScreen,
                            isMediumScreen,
                            isLargeScreen,
                            50,
                            70,
                            80,
                            90
                        ).dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextField(
                    value = confirmPassword,
                    onValueChange = { newConfirmPassword -> confirmPassword = newConfirmPassword},
                    placeholder = { Text("confirm password") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.profile),
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
        }
        Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Button(
                    onClick = {
                        println(username)
                        println(email)
                        println(password)
                        println(confirmPassword)
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF0057FF)),
                    modifier = Modifier
                        .offset(
                            0.dp,
                            DynamicPadding(
                                isSmallScreen,
                                isMediumScreen,
                                isLargeScreen,
                                580,
                                640,
                                700,
                                760
                            ).dp
                        )
                        .width(320.dp)
                        .height(56.dp)
                ) {
                    Text(
                        text = "Sign Up",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(450),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                }

            HyperlinkText(
                Url = "https://github.com/",
                Text = "Log In",
                textSize = 16,
                horizontalOffset = 0,
                verticalOffset = DynamicPadding(
                                isSmallScreen,
                                isMediumScreen,
                                isLargeScreen,
                                600,
                                660,
                                720,
                                800
                            )
            )
        }
    }
}