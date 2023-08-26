import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json          = Json { allowStructuredMapKeys = true }
// val resCheckToken = json.parse(ResCheckToken.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResCheckToken (
    val error: CheckTokenError? = null,
    val res: CheckTokenOut? = null
)

@Serializable
data class CheckTokenError (
    val type: Type
)

@Serializable
enum class ResCheckTokenErrorType(val value: String) {
    @SerializedName("Ignore") Ignore("Ignore");
}

@Serializable
data class CheckTokenOut (
    @SerializedName("user_id")
    val userID: Long? = null
)
