package com.example.bubbel.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.example.bubbel.databinding.ActivitySignupBinding
import com.example.bubbel.viewmodel.SignUpViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpView : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retrieve text input from screen
        val username:String = binding.usernameInputFieldSignup.toString()
        val email:String = binding.emailInputFieldSignup.toString()
        val password:String = binding.passwordInputFieldSignup.toString()
        val confirmPassword = binding.confirmPasswordInputFieldSignup.toString()

        binding.signUpButton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.submitSignUp(username, email, password, confirmPassword)
                println("success")
            }
        }
    }


}