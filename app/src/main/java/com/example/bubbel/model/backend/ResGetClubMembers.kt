import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json              = Json { allowStructuredMapKeys = true }
// val resGetClubMembers = json.parse(ResGetClubMembers.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetClubMembers (
    val error: GetClubMembersError? = null,
    val res: GetClubMembersOut? = null
)

@Serializable
data class GetClubMembersError (
    val ierror: String,
    val type: Type
)

@Serializable
enum class ResGetClubMembersErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal");
}

@Serializable
data class GetClubMembersOut (
    val users: List<Long>
)
