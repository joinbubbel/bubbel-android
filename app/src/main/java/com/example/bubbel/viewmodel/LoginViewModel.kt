package com.example.bubbel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bubbel.model.InAuthUser
import com.example.bubbel.model.ResAuthUser
import com.example.bubbel.repository.UserRepository

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    val _reAuthUser = MutableLiveData<ResAuthUser?>()

     val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error
    suspend fun submitLogIn(username: String, password: String) {
//        return userRepository.loginUserView(InAuthUser(username, password))
        userRepository.loginUser(InAuthUser(username, password),
            onSuccess = { resAuthUser ->
                _reAuthUser.value = resAuthUser
                        },
            onError = { error ->
                _error.value = error
            }
        )

    }
}