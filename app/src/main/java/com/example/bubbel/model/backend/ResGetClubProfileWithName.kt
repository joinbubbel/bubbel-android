import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                      = Json { allowStructuredMapKeys = true }
// val resGetClubProfileWithName = json.parse(ResGetClubProfileWithName.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetClubProfileWithName (
    val error: GetClubProfileWithNameError? = null,
    val res: GetClubProfileWithNameOut? = null
)

@Serializable
data class GetClubProfileWithNameError (
    val type: ResGetClubProfileWithNameErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetClubProfileWithNameErrorType(val value: String) {
    @SerializedName("ClubNotFound") ClubNotFound("ClubNotFound"),
    @SerializedName("Internal") Internal("Internal");
}

@Serializable
data class GetClubProfileWithNameOut (
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
