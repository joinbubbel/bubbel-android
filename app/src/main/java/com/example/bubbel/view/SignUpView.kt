package com.example.bubbel.view


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.bubbel.databinding.ActivitySignupBinding
import com.example.bubbel.databinding.MainLayoutBinding
import com.example.bubbel.viewmodel.LoginViewModel
import com.example.bubbel.viewmodel.SignUpViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var binding: ActivitySignupBinding =
        ActivitySignupBinding.inflate(LayoutInflater.from(context), this, true)
    private lateinit var viewModel: SignUpViewModel

    init {
        setupViews()
    }

    private fun setupViews() {
        val signUpButton = binding.signUpButton

        signUpButton.setOnClickListener {
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
    }

    fun setViewModel(viewModel: SignUpViewModel) {
        this.viewModel = viewModel
    }


}
