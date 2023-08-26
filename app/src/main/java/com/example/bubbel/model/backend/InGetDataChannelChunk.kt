import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                  = Json { allowStructuredMapKeys = true }
// val inGetDataChannelChunk = json.parse(InGetDataChannelChunk.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class InGetDataChannelChunk (
    @SerializedName("channel_id")
    val channelID: Long,

    @SerializedName("chunk_index")
    val chunkIndex: Long,

    val token: String
)
