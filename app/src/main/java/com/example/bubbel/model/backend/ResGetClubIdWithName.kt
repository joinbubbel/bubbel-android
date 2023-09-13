import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                 = Json { allowStructuredMapKeys = true }
// val resGetClubIDWithName = json.parse(ResGetClubIDWithName.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetClubIDWithName (
    val error: GetClubIDWithNameError? = null,
    val res: GetClubIDWithNameOut? = null
)

@Serializable
data class GetClubIDWithNameError (
    val type: ResGetClubIdWithNameErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetClubIdWithNameErrorType(val value: String) {
    @SerializedName("ClubNotFound") ClubNotFound("ClubNotFound"),
    @SerializedName("Internal") Internal("Internal");
}

@Serializable
data class GetClubIDWithNameOut (
    @SerializedName("club_id")
    val clubID: Long
)
