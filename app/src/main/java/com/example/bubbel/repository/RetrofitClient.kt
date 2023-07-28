package com.example.bubbel.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val api: loginService by lazy {
        Retrofit.Builder()
            .baseUrl("https://bubbel-bath.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(loginService::class.java)
    }
}