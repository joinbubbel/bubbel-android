import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                      = Json { allowStructuredMapKeys = true }
// val resGetMessageGroupMembers = json.parse(ResGetMessageGroupMembers.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetMessageGroupMembers (
    val error: GetMessageGroupMembersError? = null,
    val res: GetMessageGroupMembersOut? = null
)

@Serializable
data class GetMessageGroupMembersError (
    val type: ResGetMessageGroupMembersErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetMessageGroupMembersErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NotGroupMember") NotGroupMember("NotGroupMember");
}

@Serializable
data class GetMessageGroupMembersOut (
    val members: List<Long>
)
