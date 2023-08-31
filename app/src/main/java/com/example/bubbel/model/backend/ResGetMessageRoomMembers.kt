import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                     = Json { allowStructuredMapKeys = true }
// val resGetMessageRoomMembers = json.parse(ResGetMessageRoomMembers.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetMessageRoomMembers (
    val error: GetMessageRoomMembersError? = null,
    val res: GetMessageRoomMembersOut? = null
)

@Serializable
data class GetMessageRoomMembersError (
    val type: ResGetMessageRoomMembersErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetMessageRoomMembersErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NotMessageRoomMember") NotMessageRoomMember("NotMessageRoomMember");
}

@Serializable
data class GetMessageRoomMembersOut (
    val members: List<Long>
)
