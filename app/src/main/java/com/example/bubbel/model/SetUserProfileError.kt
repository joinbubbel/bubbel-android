package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class SetUserProfileError(
    val type: SetUserProfileErrorType,
    val ierror: String? = null
)
