package com.example.bubbel.view.onboarding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bubbel.R
import com.example.bubbel.viewmodel.onboarding.SplashViewModel

class SplashFragment : Fragment() {
    val viewModel: SplashViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_appView)
                                                    // when{
                // viewModel.isFirstTime() -> findNavController().navigate(R.id.action_splashFragment_to_signUpFragment)
                // viewModel.isLoggedIn() -> findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                // else -> findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            //}
        }, DELAY_MILLIS)
    }

    companion object {
        private const val DELAY_MILLIS = 3000L // This is a delay time in milliseconds
    }
}
