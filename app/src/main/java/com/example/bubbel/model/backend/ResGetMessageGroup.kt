import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json               = Json { allowStructuredMapKeys = true }
// val resGetMessageGroup = json.parse(ResGetMessageGroup.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetMessageGroup (
    val error: GetMessageGroupError? = null,
    val res: GetMessageGroupOut? = null
)

@Serializable
data class GetMessageGroupError (
    val type: ResGetMessageGroupErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResGetMessageGroupErrorType(val value: String) {
    @SerializedName("GroupNotFound") GroupNotFound("GroupNotFound"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NotGroupMember") NotGroupMember("NotGroupMember");
}

@Serializable
data class GetMessageGroupOut (
    @SerializedName("dc_id")
    val dcID: Long,

    val name: String? = null
)
