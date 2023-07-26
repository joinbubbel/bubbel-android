package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class ResCreateUser(val error: CreateUserError? = null)
