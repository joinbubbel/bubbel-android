package com.example.bubbel.model

import kotlinx.serialization.Serializable

@Serializable
data class ResAuthUser( val email: String? = null,
                        val error: AuthUserError? = null,
                        val token: String? = null,
                        val username: String? = null)
