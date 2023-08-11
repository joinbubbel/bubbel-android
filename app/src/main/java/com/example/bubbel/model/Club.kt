package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class Club(
    var image: String?,
    var title: String?,
    var isVerified: Boolean?,
    var membersOnline: String?
)
