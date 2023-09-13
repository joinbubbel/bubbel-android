package com.example.bubbel.viewmodel.onboarding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.bubbel.model.backend.InCreateUser
import com.example.bubbel.repository.BackendRepository

class VerificationViewModel(userID:Long, application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    private val backendRepository = BackendRepository(context)

    suspend fun submitVerification(

    ) {

    }

    suspend fun verification(code:String){
    }
    suspend fun resendEmail(){

    }
}