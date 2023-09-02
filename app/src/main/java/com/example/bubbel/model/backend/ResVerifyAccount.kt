// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json             = Json { allowStructuredMapKeys = true }
// val resVerifyAccount = json.parse(ResVerifyAccount.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResVerifyAccount (
    val error: VerifyAccountError? = null,
    val res: JsonElement? = null
)

/**
 * My favorite error message.
 */
@Serializable
data class VerifyAccountError (
    val type: ResVerifyAccountErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResVerifyAccountErrorType(val value: String) {
    @SerializedName("CodeTimedOutOrAlreadyVerifiedOrInvalidCode") CodeTimedOutOrAlreadyVerifiedOrInvalidCode("CodeTimedOutOrAlreadyVerifiedOrInvalidCode"),
    @SerializedName("Internal") Internal("Internal");
}
