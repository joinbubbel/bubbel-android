package com.example.bubbel.viewmodel.onboarding

import androidx.lifecycle.ViewModel
import com.example.bubbel.model.App

class SplashViewModel: ViewModel() {

    public fun isFirstTime(): Boolean{
        return App.prefs.getBoolean("firstTime", false)
    }
    public fun isLoggedIn(): Boolean{
        return App.prefs.getBoolean("loggedIn", false)
    }
}