package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class ResSetUserProfile(val error: SetUserProfileError? = null)
