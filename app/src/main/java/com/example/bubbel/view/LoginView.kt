package com.example.bubbel.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.bubbel.databinding.ActivityLoginBinding
import com.example.bubbel.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginView:AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel._reAuthUser.observe(this, Observer { reAuthUser ->
            if (reAuthUser != null) {
                binding.progressCircular.hide()
                showDialog("Successful!", "Login Successful!")
//                startActivity(Intent(this, MainActivity::class.java))
            }
        })

        viewModel._error.observe(this, Observer { errorMsg ->
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
        val alertDialog = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()

        alertDialog.show()
    }
}