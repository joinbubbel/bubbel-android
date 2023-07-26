package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class DeleteUserError(
    val type: DeleteUserErrorType,
    val ierror: String? = null
)
