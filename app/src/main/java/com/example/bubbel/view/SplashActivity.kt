package com.example.bubbel.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bubbel.R
import com.example.bubbel.databinding.ActivitySplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_signUpFragment)
        }, DELAY_MILLIS)
    }

    companion object {
        private const val DELAY_MILLIS = 3000L // This is a delay time in milliseconds
    }
}
