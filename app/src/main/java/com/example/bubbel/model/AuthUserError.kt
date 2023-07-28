package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthUserError(
    val type: AuthUserErrorType,
    val error: String? = null
)
