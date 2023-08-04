package com.example.bubbel.viewmodel.onboarding

import InCreateUser
import androidx.lifecycle.ViewModel
import bubbelApiCreateUser
import kotlinx.serialization.SerializationException
import com.example.bubbel.model.FetchErrorException


class SignUpViewModel: ViewModel() {
        suspend fun submitSignUp(username: String, email:String, password:String, confirmPassword:String) {
            //Check if password = confirm password
            if (password != confirmPassword){
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

            //Create api request
            try {
                bubbelApiCreateUser(user)
                println("cowfire")
            } catch (ex: SerializationException){
                throw FetchErrorException("Error decoding response: ${ex.message}")
                println("Firecow")
                return
            }
        }
}

