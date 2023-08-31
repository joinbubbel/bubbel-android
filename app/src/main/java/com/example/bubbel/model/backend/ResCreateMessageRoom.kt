import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                 = Json { allowStructuredMapKeys = true }
// val resCreateMessageRoom = json.parse(ResCreateMessageRoom.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResCreateMessageRoom (
    val error: CreateMessageRoomError? = null,
    val res: CreateMessageRoomOut? = null
)

@Serializable
data class CreateMessageRoomError (
    val type: ResCreateMessageRoomErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResCreateMessageRoomErrorType(val value: String) {
    @SerializedName("ClubNotFound") ClubNotFound("ClubNotFound"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NotOwner") NotOwner("NotOwner");
}

@Serializable
data class CreateMessageRoomOut (
    @SerializedName("message_room_id")
    val messageRoomID: Long
)
