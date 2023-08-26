import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                    = Json { allowStructuredMapKeys = true }
// val dataChannelInitResponse = json.parse(DataChannelInitResponse.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class DataChannelInitResponse (
    @SerializedName("current_chunk")
    val currentChunk: Long? = null,

    val error: DataChannelInitError? = null
)

@Serializable
data class DataChannelInitError (
    val type: Type,
    val ierror: String? = null
)

@Serializable
enum class Type(val value: String) {
    @SerializedName("ChannelNotFound") ChannelNotFound("ChannelNotFound"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}
