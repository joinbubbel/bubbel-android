package com.example.bubbel.viewmodel.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bubbel.model.backend.InCreateUser
import com.example.bubbel.model.backend.ResAuthUser
import com.example.bubbel.repository.BackendRepository
import com.example.bubbel.model.backend.InSendVerify
import com.example.bubbel.model.backend.ResCreateUser
import com.example.bubbel.model.backend.UserId
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

        //Create user
        val user = InCreateUser(email, username, password)

        //Verifying info
        println(user)
        println(username)
        println(password)
        println(confirmPassword)
        println(email)


        backendRepository.createUser(
            user,
            onSuccess = { response ->
                // Assuming 'response' contains the necessary data to be passed as an argument for InSendVerify()

                var id = gson.toJson(response)


                val requestForSendVerify = InSendVerify(gson.fromJson(id, ResCreateUser::class.java)) // Modify this as per your need
                println(requestForSendVerify)
                viewModelScope.launch {
                    backendRepository.sendVerify(
                        request = requestForSendVerify,
                        onSuccess = { responseOfSendVerify ->
                            // Handle successful response here
                            // 'responseOfSendVerify' contains the parsed response data
                        },
                        onError = { errorMessageOfSendVerify ->
                            // Handle error here
                            // 'errorMessageOfSendVerify' contains the error message
                        }
                    )
                }
            },
            onError = { errorMessage ->
                // Handle error here
                // 'errorMessage' contains the error message
            }
        )
    }
}

