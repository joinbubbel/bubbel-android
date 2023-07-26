package com.example.bubbel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class DeleteUserErrorType(val value: String) {
    @SerialName("Internal")
    Internal("Internal"),
    @SerialName("NoAuth")
    NoAuth("NoAuth");
}