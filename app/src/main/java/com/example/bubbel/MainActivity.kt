package com.example.bubbel

import android.os.Bundle
import android.text.Layout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.*
import androidx.compose.material3.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.*
import androidx.compose.ui.tooling.preview.*
import com.example.bubbel.ui.theme.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.ui.res.*
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Horizontal
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign

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
fun LoginInputs(){
    var username by remember{
        mutableStateOf("")
    }
    var password by remember{
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
           modifier = Modifier.offset(0.dp, 80.dp),

       ) {
           Row(
               horizontalArrangement = Arrangement.Center
           ) {
               Text(
                   text = "Pop-up notifications",
                   color = Color.Black
               )
           }
           Column(
               verticalArrangement = Arrangement.Center,
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(top = 80.dp)
                   .align(Alignment.Horizontal),
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
                       .background(color = Color(0xFF0057FF), shape = RoundedCornerShape(10.dp))
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
           }
       }
   }
}