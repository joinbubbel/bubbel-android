package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserError(val type: CreateUserErrorType,
                           val ierror: String? = null)
