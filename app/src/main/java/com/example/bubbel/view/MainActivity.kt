package com.example.bubbel.view

//Library dependencies
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bubbel.R

//backend import

//layout imports
import com.example.bubbel.databinding.MainLayoutBinding
import com.example.bubbel.viewmodel.SignUpViewModel

class MainActivity : ComponentActivity() {
    private lateinit var signUpView: SignUpView
    private val viewModel: SignUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val container: ViewGroup = findViewById(R.id.screenContainer)

        signUpView = SignUpView(this)
        signUpView.setViewModel(viewModel)

        container.addView(signUpView)
    }
}


