package com.example.bubbel.view.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bubbel.databinding.ClubScreenBinding
import com.example.bubbel.viewmodel.app.ClubViewModel

class ClubView:Fragment() {
    private lateinit var binding: ClubScreenBinding
    val viewModel: ClubViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ClubScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}