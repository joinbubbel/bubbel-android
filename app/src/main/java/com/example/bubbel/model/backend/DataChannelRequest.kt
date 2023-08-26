import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json               = Json { allowStructuredMapKeys = true }
// val dataChannelRequest = json.parse(DataChannelRequest.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class DataChannelRequest (
    val command: DataChannelCommandType,
    val token: String
)

@Serializable
data class DataChannelCommandType (
    val message: Message? = null,
    val type: DataChannelCommandTypeType,
    val chunk: Long? = null,
    val index: Long? = null
)

@Serializable
data class Message (
    val text: String,
    val type: MessageType
)

@Serializable
enum class MessageType(val value: String) {
    @SerializedName("Text") Text("Text");
}

@Serializable
enum class DataChannelCommandTypeType(val value: String) {
    @SerializedName("Delete") Delete("Delete"),
    @SerializedName("Send") Send("Send");
}
