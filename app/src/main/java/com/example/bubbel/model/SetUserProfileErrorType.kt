package com.example.bubbel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SetUserProfileErrorType(val value: String) {
    @SerialName("Internal")
    Internal("Internal"),
    @SerialName("NoAuth")
    NoAuth("NoAuth");
}