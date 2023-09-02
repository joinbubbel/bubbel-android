// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json          = Json { allowStructuredMapKeys = true }
// val resDeleteUser = json.parse(ResDeleteUser.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResDeleteUser (
    val error: DeleteUserError? = null,
    val res: JsonElement? = null
)

@Serializable
data class DeleteUserError (
    val type: ResDeleteUserErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResDeleteUserErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}
