// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                    = Json { allowStructuredMapKeys = true }
// val resGetFriendConnections = json.parse(ResGetFriendConnections.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import com.google.gson.annotations.SerializedName

@Serializable
data class ResGetFriendConnections (
    val error: GetFriendConnectionsError? = null,
    val res: GetFriendConnectionsOut? = null
)

@Serializable
data class GetFriendConnectionsError (
    val type: ResGetFriendConnectionsErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetFriendConnectionsErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class GetFriendConnectionsOut (
    @SerializedName("friend_connections")
    val friendConnections: Map<String, FriendStatus>
)

@Serializable
enum class FriendStatus(val value: String) {
    @SerializedName("Full") Full("Full"),
    @SerializedName("RecievedPending") RecievedPending("RecievedPending"),
    @SerializedName("SentPending") SentPending("SentPending");
}
