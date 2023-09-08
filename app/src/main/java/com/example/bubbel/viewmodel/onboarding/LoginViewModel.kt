package com.example.bubbel.viewmodel.onboarding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bubbel.model.backend.InAuthUser
import com.example.bubbel.model.backend.ResAuthUser
import com.example.bubbel.repository.BackendRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext

    private  val  backendRepository = BackendRepository(context)

    val _reAuthUser = MutableLiveData<ResAuthUser?>()

     val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error
    suspend fun submitLogIn(username: String, password: String) {
//        return userRepository.loginUserView(InAuthUser(username, password))
        backendRepository.authUser(
            InAuthUser(username, password),
            onSuccess = { resAuthUser ->
                _reAuthUser.value = resAuthUser
                        },
            onError = { error ->
                _error.value = error
            }
        )

    }
}