import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                   = Json { allowStructuredMapKeys = true }
// val resGetClubMessageRooms = json.parse(ResGetClubMessageRooms.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetClubMessageRooms (
    val error: GetClubMessageRoomsError? = null,
    val res: GetClubMessageRoomsOut? = null
)

@Serializable
data class GetClubMessageRoomsError (
    val type: ResGetClubMessageRoomsErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetClubMessageRoomsErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NotClubMember") NotClubMember("NotClubMember");
}

@Serializable
data class GetClubMessageRoomsOut (
    @SerializedName("message_rooms")
    val messageRooms: List<Long>
)
