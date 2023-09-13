import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                     = Json { allowStructuredMapKeys = true }
// val resAddUserToMessageGroup = json.parse(ResAddUserToMessageGroup.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResAddUserToMessageGroup (
    val error: AddUserToMessageGroupError? = null,
    val res: JsonObject? = null
)

@Serializable
data class AddUserToMessageGroupError (
    val type: ResAddUserToMessageGroupErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResAddUserToMessageGroupErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NotGroupMember") NotGroupMember("NotGroupMember");
}
