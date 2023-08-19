package com.example.bubbel.view.onboarding

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bubbel.R
import com.example.bubbel.databinding.SplashScreenBinding
import com.example.bubbel.view.MainActivity
import com.example.bubbel.viewmodel.onboarding.SplashViewModel

class SplashFragment : Fragment() {
    lateinit var binding: SplashScreenBinding
    val viewModel: SplashViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(inflater, container, false)
        val rotateAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_animation)

        // Start the animation
        binding.loadingCircle.startAnimation(rotateAnimation)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            when{
                 !viewModel.isFirstTime() -> findNavController().navigate(R.id.action_splashScreenFragment_to_appView)
                 !viewModel.isLoggedIn() -> findNavController().navigate(R.id.action_splashScreenFragment_to_appView)
                 else -> findNavController().navigate(R.id.action_splashScreenFragment_to_appView)
            }
        }, DELAY_MILLIS)
    }

    companion object {
        private const val DELAY_MILLIS = 3000L // This is a delay time in milliseconds
    }
}
