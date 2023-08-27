import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                = Json { allowStructuredMapKeys = true }
// val dataChannelResponse = json.parse(DataChannelResponse.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class DataChannelResponse (
    val error: DataChannelError? = null,
    val res: DataChannelResponseType? = null
)

@Serializable
data class DataChannelError (
    val type: ErrorType,
    val ierror: String? = null
)

@Serializable
enum class ErrorType(val value: String) {
    @SerializedName("ChannelNotFound") ChannelNotFound("ChannelNotFound"),
    @SerializedName("ChunkNotFound") ChunkNotFound("ChunkNotFound"),
    @SerializedName("DataItemDeleted") DataItemDeleted("DataItemDeleted"),
    @SerializedName("DataItemNotFound") DataItemNotFound("DataItemNotFound"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class DataChannelResponseType (
    val chunk: Long,
    val index: Long,
    val item: DataChannelItem? = null,
    val type: ResType,

    @SerializedName("new_item")
    val newItem: DataChannelItem? = null
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

@Serializable
enum class ResType(val value: String) {
    @SerializedName("OnDelete") OnDelete("OnDelete"),
    @SerializedName("OnEdit") OnEdit("OnEdit"),
    @SerializedName("OnNew") OnNew("OnNew");
}
