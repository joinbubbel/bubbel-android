import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                    = Json { allowStructuredMapKeys = true }
// val resGetUserMessageGroups = json.parse(ResGetUserMessageGroups.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetUserMessageGroups (
    val error: GetUserMessageGroupsError? = null,
    val res: GetUserMessageGroupsOut? = null
)

@Serializable
data class GetUserMessageGroupsError (
    val type: ResGetUserMessageGroupsErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetUserMessageGroupsErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class GetUserMessageGroupsOut (
    val groups: List<Long>
)
