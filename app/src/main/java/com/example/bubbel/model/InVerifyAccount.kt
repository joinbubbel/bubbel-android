package com.example.bubbel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InVerifyAccount(
    val code: String,

    @SerialName("user_id")
    val userID: Long
)
