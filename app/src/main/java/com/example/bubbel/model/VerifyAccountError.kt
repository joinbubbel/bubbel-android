package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class VerifyAccountError(
    val type: VerifyAccountErrorType,
    val ierror: String? = null
)
