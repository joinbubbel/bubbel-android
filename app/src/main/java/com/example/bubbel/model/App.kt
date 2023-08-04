package com.example.bubbel.model

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class App: Application() {
    companion object{
        lateinit var prefs:SharedPreferences
    }
    override fun onCreate() {
        prefs = applicationContext.getSharedPreferences(
            "com.example.bubbel", Context.MODE_PRIVATE
        )
        super.onCreate()
    }
}