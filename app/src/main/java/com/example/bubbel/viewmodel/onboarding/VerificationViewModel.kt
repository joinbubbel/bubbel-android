package com.example.bubbel.viewmodel.onboarding

import androidx.lifecycle.ViewModel
import com.example.bubbel.model.backend.InCreateUser
import com.example.bubbel.repository.BackendRepository

class VerificationViewModel : ViewModel() {
    private val backendRepository = BackendRepository()

    suspend fun submitVerification(

    ) {

    }

    suspend fun verification(code:String){
    }
    suspend fun resendEmail(){

    }
}