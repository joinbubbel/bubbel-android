package com.example.bubbel.view

//Library dependencies
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.bubbel.R

//backend import

//layout imports
import com.example.bubbel.viewmodel.SignUpViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: SignUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val container: ViewGroup = findViewById(R.id.screenContainer)

    }
}


