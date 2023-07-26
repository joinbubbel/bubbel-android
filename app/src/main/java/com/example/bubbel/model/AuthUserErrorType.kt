package com.example.bubbel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AuthUserErrorType(val value: String) {

    @SerialName("Internal")
    Internal("Internal"),
    @SerialName("InvalidCredentials")
    InvalidCredentials("InvalidCredentials"),
    @SerialName("InvalidPasswordCryto")
    InvalidPasswordCryto("InvalidPasswordCryto"),
    @SerialName("UserNotFound")
    UserNotFound("UserNotFound"),
    @SerialName("UserNotVerified")
    UserNotVerified("UserNotVerified");
}