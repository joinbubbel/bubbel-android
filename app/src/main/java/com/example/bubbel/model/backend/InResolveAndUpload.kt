import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json               = Json { allowStructuredMapKeys = true }
// val inResolveAndUpload = json.parse(InResolveAndUpload.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class InResolveAndUpload (
    val token: String,
    val url: String
)
