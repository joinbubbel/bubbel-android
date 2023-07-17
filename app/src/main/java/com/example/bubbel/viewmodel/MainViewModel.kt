package com.example.bubbel.viewmodel

import InCreateUser
import UserRepository
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun submitSignUp(
        username: String,
        password: String,
        email: String,
        confirmPassword: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            if (password != confirmPassword) {
                onError("Password and confirm password do not match")
                return@launch
            }
            try {
                val user = InCreateUser(email, username, password)
                userRepository.createUser(user)
                onSuccess()
            } catch (ex: SerializationException) {
                onError("Error decoding response: ${ex.message}")
            } catch (ex: FetchErrorException) {
                onError("Error fetching data: ${ex.message}")
            }
        }
    }
}
