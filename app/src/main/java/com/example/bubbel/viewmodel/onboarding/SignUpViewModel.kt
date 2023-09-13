package com.example.bubbel.viewmodel.onboarding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bubbel.R
import com.example.bubbel.model.backend.CreateUserError
import com.example.bubbel.model.backend.InCreateUser
import com.example.bubbel.model.backend.ResAuthUser
import com.example.bubbel.repository.BackendRepository
import com.example.bubbel.model.backend.InSendVerify
import com.example.bubbel.model.backend.ResCreateUser
import com.google.gson.Gson
import kotlinx.coroutines.launch


class SignUpViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext

    private val backendRepository = BackendRepository(context)

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

        println("flane")
        //Create user object
        val user = InCreateUser(email, password, username)
        println(user)
        //Send create user request to the server
        backendRepository.createUser(
            user,
            onSuccess = { response ->
               verify(response)
            },
            onError = { errorMessage ->
                println(errorMessage)
                println("create User error")
            }
        )
    }
    fun verify(response:ResCreateUser?){

        val userId = response?.res?.userID
        println("Response received: $response")
        println("UserID extracted: $userId")

        if (userId == null || userId <= 0){
            println("Invalid UserID, cannot send verification mail")
            return
        }

        println("Create user response")

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
    }
}

