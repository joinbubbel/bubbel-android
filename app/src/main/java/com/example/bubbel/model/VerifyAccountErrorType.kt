package com.example.bubbel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class VerifyAccountErrorType(val value: String) {
    @SerialName("CodeTimedOutOrInvalidUser")
    CodeTimedOutOrInvalidUser("CodeTimedOutOrInvalidUser"),
    @SerialName("Internal")
    Internal("Internal"),
    @SerialName("InvalidCode")
    InvalidCode("InvalidCode");
}
