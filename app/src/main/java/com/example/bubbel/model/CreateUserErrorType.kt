package com.example.bubbel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CreateUserErrorType(val value: String) {
    @SerialName("EmailOrUsernametaken") EmailOrUsernametaken("EmailOrUsernametaken"),
    @SerialName("Internal") Internal("Internal"),
    @SerialName("InvalidEmail") InvalidEmail("InvalidEmail"),
    @SerialName("InvalidPassword") InvalidPassword("InvalidPassword"),
    @SerialName("InvalidPasswordCryto") InvalidPasswordCryto("InvalidPasswordCryto"),
    @SerialName("InvalidUsername") InvalidUsername("InvalidUsername"),
    @SerialName("SendVerification") SendVerification("SendVerification");
}