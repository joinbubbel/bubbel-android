package com.example.bubbel.repository

import com.example.bubbel.model.InAuthUser
import com.example.bubbel.model.ResAuthUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface loginService {
    @POST("/api/auth_user")
    fun loginUser(@Body userData: InAuthUser): Call<ResAuthUser>
}