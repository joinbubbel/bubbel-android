package com.example.bubbel.viewmodel

import InCreateUser
import UserRepository
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {
}
