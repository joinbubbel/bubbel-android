package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class InAuthUser(val username: String, val password: String,)
