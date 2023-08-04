package com.example.bubbel.view.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bubbel.R
import com.example.bubbel.databinding.AppScreenBinding
import com.example.bubbel.viewmodel.app.AppViewModel

class AppView : Fragment() {
    private lateinit var binding: AppScreenBinding
    private val viewModel: AppViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AppScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize your HomeScreenFragment
        val homeScreenFragment = HomeScreenView() // Replace with your actual HomeScreenFragment class

        // Use the child FragmentManager to replace your FrameLayout with your Fragment
        childFragmentManager.beginTransaction().replace(R.id.flFragment, homeScreenFragment).commit()
    }
}
