package com.example.bubbel.viewmodel.onboarding

import androidx.compose.material3.AlertDialog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bubbel.model.backend.CreateUserOut
import com.example.bubbel.model.backend.InCreateUser
import com.example.bubbel.model.backend.ResAuthUser
import com.example.bubbel.repository.BackendRepository
import com.example.bubbel.model.backend.InSendVerify
import com.example.bubbel.model.backend.ResCreateUser
import com.google.gson.Gson
import kotlinx.coroutines.launch


class SignUpViewModel : ViewModel() {

    private val backendRepository = BackendRepository()

    val _reAuthUser = MutableLiveData<ResAuthUser?>()

    val gson = Gson()

    val _error = MutableLiveData<String>()
    suspend fun submitSignUp(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        //Check if password = confirm password
        if (password != confirmPassword) {
            println("Password and confirm password do not match")
            return
        }

        //Create user object
        val user = InCreateUser(email, username, password)

        //Send create user request to the server
        backendRepository.createUser(
            user,
            onSuccess = { response ->
                val userId = response?.res?.userID

                if (userId != null){
                val requestForSendVerify = InSendVerify(userId.toString().toLong())

                viewModelScope.launch {
                    backendRepository.sendVerify(
                        request = requestForSendVerify,
                        onSuccess = { responseOfSendVerify ->
                            println("Verification sent")
                            println(responseOfSendVerify)
                        },
                        onError = { errorMessageOfSendVerify ->
                            println(errorMessageOfSendVerify)
                            println("Send verify error")
                            println(requestForSendVerify)
                        }
                    )
                }
                }
            },
            onError = { errorMessage ->
                println(errorMessage)
                println("create User error")
            }
        )
    }
}

