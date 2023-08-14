package com.example.bubbel.view.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bubbel.R
import com.example.bubbel.databinding.SignupScreenBinding
import com.example.bubbel.viewmodel.onboarding.SignUpViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {
    private lateinit var binding: SignupScreenBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignupScreenBinding.inflate(inflater, container, false)
        setupViews()
        return binding.root
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
                findNavController().navigate(R.id.action_signUpFragment_to_verificationFragment)
            }
        }
        binding.loginButton.setOnClickListener {
            print("ok")
            val saveIntent = Intent(requireContext(), LoginFragment::class.java)
            startActivity(saveIntent)
        }
    }
}