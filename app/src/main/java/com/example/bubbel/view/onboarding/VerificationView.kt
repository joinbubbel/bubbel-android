package com.example.bubbel.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bubbel.R
import com.example.bubbel.databinding.VerificationScreenBinding
import com.example.bubbel.viewmodel.onboarding.VerificationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VerificationView : Fragment() {
    lateinit var binding: VerificationScreenBinding
    private val viewModel: VerificationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = VerificationScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupViews() {
        binding.loginButton.setOnClickListener {
            val verificationCode = binding.verificationInputField.text.toString()


            CoroutineScope(Dispatchers.Main).launch {
                viewModel.submitVerification()
                println("success")

                findNavController().navigate(R.id.action_signUpFragment_to_verificationFragment)
            }
        }
        binding.signUpButton.setOnClickListener{

            findNavController().navigate(R.id.action_verificationFragment_to_loginFragment)
        }
    }

}
