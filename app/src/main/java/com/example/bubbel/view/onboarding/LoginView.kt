package com.example.bubbel.view.onboarding

import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.example.bubbel.databinding.LoginScreenBinding
import com.example.bubbel.viewmodel.onboarding.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var binding: LoginScreenBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LoginScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel._reAuthUser.observe(viewLifecycleOwner, Observer { reAuthUser ->
            if (reAuthUser != null) {
                binding.progressCircular.hide()
                showDialog("Successful!", "Login Successful!")
            }
        })

        viewModel._error.observe(viewLifecycleOwner, Observer { errorMsg ->
            binding.progressCircular.hide()
            showDialog("Error", errorMsg.toString())
        })

        binding.loginButton.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                binding.progressCircular.visibility = View.VISIBLE
                binding.progressCircular.show()
                viewModel.submitLogIn(binding.edtUserName.text.toString(),binding.edtPsw.text.toString())
            }
        }
    }

    private fun showDialog(title: String, message: String) {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()

        alertDialog.show()
    }
}
