package com.example.bubbel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

class FetchErrorException(message: String) : Exception(message)


@Serializable
data class ResDeleteUser (
        val error: DeleteUserError? = null
    )
