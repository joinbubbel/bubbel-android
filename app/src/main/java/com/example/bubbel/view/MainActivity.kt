package com.example.bubbel.view

//Library dependencies
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

//backend import

//layout imports
import com.example.bubbel.databinding.MainLayoutBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding:MainLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}


