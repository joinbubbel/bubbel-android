// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                          = Json { allowStructuredMapKeys = true }
// val resGetUserProfileWithUsername = json.parse(ResGetUserProfileWithUsername.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import com.google.gson.annotations.SerializedName

@Serializable
data class ResGetUserProfileWithUsername (
    val error: GetUserProfileWithUsernameError? = null,
    val res: GetUserProfileWithUsernameOut? = null
)

@Serializable
data class GetUserProfileWithUsernameError (
    val type: ResGetUserProfileWithUsernameErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetUserProfileWithUsernameErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("UserNotFound") UserNotFound("UserNotFound");
}

@Serializable
data class GetUserProfileWithUsernameOut (
    val banner: String? = null,
    val description: String? = null,

    @SerializedName("display_name")
    val displayName: String? = null,

    val name: String? = null,
    val pfp: String? = null
)
