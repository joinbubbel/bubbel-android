package com.example.bubbel.view.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bubbel.databinding.ProfileScreenBinding
import com.example.bubbel.viewmodel.app.ProfileViewModel

class ProfileView:Fragment() {
    private lateinit var binding: ProfileScreenBinding
    val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}