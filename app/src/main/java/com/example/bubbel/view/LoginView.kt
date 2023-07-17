package com.example.bubbel.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bubbel.databinding.ActivityLoginBinding
import com.example.bubbel.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginView:AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retrieve username and password from login input
        val username: String = binding.usernameInputField.text.toString()
        val password: String = binding.passwordInputField.text.toString()
        binding.loginButton.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.submitLogIn(username, password,)
                println("success")
            }
        }
    }
}