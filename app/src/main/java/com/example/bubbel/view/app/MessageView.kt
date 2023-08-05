package com.example.bubbel.view.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bubbel.databinding.MessageScreenBinding
import com.example.bubbel.viewmodel.app.MessageViewModel

class MessageView:Fragment() {
    private lateinit var binding: MessageScreenBinding
    val viewModel: MessageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MessageScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}