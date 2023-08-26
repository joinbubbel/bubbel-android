// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json            = Json { allowStructuredMapKeys = true }
// val resUsernameToID = json.parse(ResUsernameToID.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResUsernameToID (
    val error: UsernameToIDError? = null,
    val res: UsernameToIDOut? = null
)

@Serializable
data class UsernameToIDError (
    val type: ResUsernameToIdErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResUsernameToIdErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("UserNotFound") UserNotFound("UserNotFound");
}

@Serializable
data class UsernameToIDOut (
    @SerializedName("user_id")
    val userID: Long
)
