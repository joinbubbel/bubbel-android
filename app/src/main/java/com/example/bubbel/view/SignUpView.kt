package com.example.bubbel.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bubbel.databinding.ActivitySignupBinding
import com.example.bubbel.viewmodel.SignUpViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpView : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
            binding.signUpButton.setOnClickListener {
            val username = binding.usernameInputFieldSignup.text.toString()
            val email = binding.emailInputFieldSignup.text.toString()
            val password = binding.passwordInputFieldSignup.text.toString()
            val confirmPassword = binding.confirmPasswordInputFieldSignup.text.toString()

            // Pass the input values to the SignUpViewModel for further processing
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.submitSignUp(username, email, password, confirmPassword)
                println("success")
            }
        }

        binding.signUpLink.setOnClickListener {
            print("ok")
            val saveIntent = Intent(this,LoginView::class.java)
            startActivity(saveIntent)
        }
    }

    fun setViewModel(viewModel: SignUpViewModel) {
        this.viewModel = viewModel
    }


}
