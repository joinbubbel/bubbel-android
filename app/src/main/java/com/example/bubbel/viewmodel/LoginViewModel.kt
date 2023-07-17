package com.example.bubbel.viewmodel

import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModel
import com.example.bubbel.R

class LoginViewModel:ViewModel() {
        fun submitLogIn(username:String, password:String) {

            //Verify the data
            println("Username is $username")
            println("Password is $password")
        }
}