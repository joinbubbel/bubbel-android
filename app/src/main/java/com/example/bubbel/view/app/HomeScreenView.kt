package com.example.bubbel.view.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bubbel.databinding.AppScreenBinding
import com.example.bubbel.databinding.HomeScreenBinding
import com.example.bubbel.viewmodel.app.HomeViewModel

class HomeScreenView: Fragment() {
    private lateinit var binding:HomeScreenBinding
    val viewModel:HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}