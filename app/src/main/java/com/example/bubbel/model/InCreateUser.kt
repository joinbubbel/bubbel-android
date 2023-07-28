package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class InCreateUser(
    val email: String,
    val username: String,
    val password: String,
)
