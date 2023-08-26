import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                   = Json { allowStructuredMapKeys = true }
// val resGetDataChannelChunk = json.parse(ResGetDataChannelChunk.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetDataChannelChunk (
    val error: GetDataChannelChunkError? = null,
    val res: GetDataChannelChunkOut? = null
)

@Serializable
data class GetDataChannelChunkError (
    val type: ErrorType,
    val ierror: String? = null
)

@Serializable
enum class ErrorType(val value: String) {
    @SerializedName("ChannelNotFound") ChannelNotFound("ChannelNotFound"),
    @SerializedName("ChunkNotFound") ChunkNotFound("ChunkNotFound"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class GetDataChannelChunkOut (
    val chunk: DataChunk
)

@Serializable
data class DataChunk (
    val items: List<DataChannelItem?>
)

@Serializable
data class DataChannelItem (
    @SerializedName("edit_time")
    val editTime: Long? = null,

    val message: Message,

    @SerializedName("post_time")
    val postTime: Long,

    val sender: Long
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
