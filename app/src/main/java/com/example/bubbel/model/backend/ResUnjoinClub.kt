// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json          = Json { allowStructuredMapKeys = true }
// val resUnjoinClub = json.parse(ResUnjoinClub.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResUnjoinClub (
    val error: UnjoinClubError? = null,
    val res: JsonObject? = null
)

@Serializable
data class UnjoinClubError (
    val type: ResUnjoinClubErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResUnjoinClubErrorType(val value: String) {
    @SerializedName("CannotUnjoinAsOwner") CannotUnjoinAsOwner("CannotUnjoinAsOwner"),
    @SerializedName("ClubNotFound") ClubNotFound("ClubNotFound"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}
