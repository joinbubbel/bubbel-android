import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json              = Json { allowStructuredMapKeys = true }
// val resGetMessageRoom = json.parse(ResGetMessageRoom.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetMessageRoom (
    val error: GetMessageRoomError? = null,
    val res: GetMessageRoomOut? = null
)

@Serializable
data class GetMessageRoomError (
    val type: ResGetMessageRoomErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetMessageRoomErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("MessageRoomNotFound") MessageRoomNotFound("MessageRoomNotFound"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NotMessageRoomMember") NotMessageRoomMember("NotMessageRoomMember");
}

@Serializable
data class GetMessageRoomOut (
    @SerializedName("club_id")
    val clubID: Long,

    @SerializedName("dc_id")
    val dcID: Long,

    val name: String? = null
)
