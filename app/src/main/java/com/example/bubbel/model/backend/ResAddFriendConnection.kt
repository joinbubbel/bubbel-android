// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                   = Json { allowStructuredMapKeys = true }
// val resAddFriendConnection = json.parse(ResAddFriendConnection.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import com.google.gson.annotations.SerializedName

@Serializable
data class ResAddFriendConnection (
    val error: AddFriendConnectionError? = null,
    val res: JsonObject? = null
)

@Serializable
data class AddFriendConnectionError (
    val type: ResAddFriendConnectionErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResAddFriendConnectionErrorType(val value: String) {
    @SerializedName("AlreadyConnected") AlreadyConnected("AlreadyConnected"),
    @SerializedName("CannotAddSelf") CannotAddSelf("CannotAddSelf"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}
