package com.example.bubbel.Screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.*
import com.example.bubbel.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isLoggedIn:Boolean = false
        if (!isLoggedIn){
            setContentView(R.layout.activity_login)
        }

        val usernameInput: EditText = findViewById(R.id.usernameInputField);
        val passwordInput: EditText = findViewById(R.id.passwordInputField);
        val username:String = usernameInput.getText().toString()
        val password:String = passwordInput.getText().toString()

        val forgotPassword:TextView = findViewById(R.id.forgotPasswordLink)
        forgotPassword.text = Html.fromHtml("<a href=\"https://developer.android.com/topic/libraries/view-binding\">Forgot Password?</a>")
        forgotPassword.movementMethod = LinkMovementMethod.getInstance()

        val signUp:TextView = findViewById(R.id.signUpLink)
        signUp.text = Html.fromHtml("<a href=\"https://developer.android.com/topic/libraries/view-binding\">Forgot Password?</a>")
        signUp.movementMethod = LinkMovementMethod.getInstance()

    }



}