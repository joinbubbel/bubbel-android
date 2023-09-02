// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json               = Json { allowStructuredMapKeys = true }
// val inRegexSearchClubs = json.parse(InRegexSearchClubs.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class InRegexSearchClubs (
    @SerializedName("batch_index")
    val batchIndex: Long,

    val regex: String
)
