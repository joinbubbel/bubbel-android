package com.example.bubbel.model

import kotlinx.serialization.Serializable

data class Club(
    val image: String?,
    val title: String?,
    val isVerified: Boolean,
    val membersOnline: Int
)
