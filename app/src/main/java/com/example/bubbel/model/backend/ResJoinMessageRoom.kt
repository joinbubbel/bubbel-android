import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json               = Json { allowStructuredMapKeys = true }
// val resJoinMessageRoom = json.parse(ResJoinMessageRoom.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResJoinMessageRoom (
    val error: JoinMessageRoomError? = null,
    val res: JsonObject? = null
)

@Serializable
data class JoinMessageRoomError (
    val type: ResJoinMessageRoomErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResJoinMessageRoomErrorType(val value: String) {
    @SerializedName("AlreadyJoined") AlreadyJoined("AlreadyJoined"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NotClubMember") NotClubMember("NotClubMember");
}
