package com.example.bubbel

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bubbel.Screens.*


//layout imports
import com.example.bubbel.R.layout.activity_signup
import com.example.bubbel.R.layout.activity_login


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isLoggedIn = true
            var isFirstTime = true


            fun loginScreen(){
                setContentView(R.layout.activity_login)

                val textView: TextView = findViewById(R.id.forgotPasswordLink)
                textView.text = Html.fromHtml("<a href=\"https://developer.android.com/topic/libraries/view-binding\">Forgot Password?</a>")
                textView.movementMethod = LinkMovementMethod.getInstance()

                val signUp:TextView = findViewById(R.id.signUpLink)
                signUp.text = Html.fromHtml("<a href=\"https://developer.android.com/topic/libraries/view-binding\">Sign Up ></a>")
                signUp.movementMethod = LinkMovementMethod.getInstance()

                fun submitLogIn() {
                    //retrieve user input from login screen
                    val usernameInput: EditText = findViewById(R.id.usernameInputField)
                    val passwordInput: EditText = findViewById(R.id.passwordInputField)

                    //turn it into a string
                    val username: String = usernameInput.text.toString()
                    val password: String = passwordInput.text.toString()

                    //Verify the data
                    println("Username is $username")
                    println("Password is $password")
                }

                val logInButton: Button = findViewById(R.id.loginButton)

                logInButton.setOnClickListener {
                    submitLogIn()
                }
            }
            fun signUpScreen(){
                setContentView(R.layout.activity_signup)
                fun submitSignUp() {
                    //Get inputs from text field
                    val usernameInput: EditText = findViewById(R.id.usernameInputFieldSignup)
                    val passwordInput: EditText = findViewById(R.id.passwordInputFieldSignup)
                    val emailInput:EditText = findViewById(R.id.emailInputFieldSignup)
                    val confirmPasswordInput:EditText = findViewById(R.id.confirmPasswordInputFieldSignup)

                    //Turn this values into strings
                    val username: String = usernameInput.text.toString()
                    val password: String = passwordInput.text.toString()
                    val email:String = emailInput.text.toString()
                    val confirmPassword:String = confirmPasswordInput.text.toString()

                    //Verifying info
                    println("Username is $username")
                    println("Email is $email")
                    println("Password is $password")
                    print("Confirmed Password is $confirmPassword")
                }
                val signUpButton: Button = findViewById(R.id.signUpButton)

                signUpButton.setOnClickListener {
                    submitSignUp()
                }
            }
            if (!isLoggedIn){
                loginScreen()
            }
            if (isFirstTime){
                signUpScreen()
                isFirstTime = false
            }
            else{
                println("Home")
            }
        }
    }
}


