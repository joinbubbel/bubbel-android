// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json              = Json { allowStructuredMapKeys = true }
// val resGetClubProfile = json.parse(ResGetClubProfile.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetClubProfile (
    val error: GetClubProfileError? = null,
    val res: GetClubProfileOut? = null
)

@Serializable
data class GetClubProfileError (
    val type: ResGetClubProfileErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetClubProfileErrorType(val value: String) {
    @SerializedName("ClubNotFound") ClubNotFound("ClubNotFound"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class GetClubProfileOut (
    val banner: String? = null,

    @SerializedName("dc_id")
    val dcID: Long,

    val description: String? = null,

    @SerializedName("display_name")
    val displayName: String? = null,

    @SerializedName("is_member")
    val isMember: Boolean? = null,

    val name: String,
    val owner: Long,
    val pfp: String? = null
)
