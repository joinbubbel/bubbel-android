// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json          = Json { allowStructuredMapKeys = true }
// val resSendVerify = json.parse(ResSendVerify.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResSendVerify (
    val error: SendVerifyError? = null,
    val res: JsonElement? = null
)

/**
 * Failed to send the verification message (usually an email error).
 */
@Serializable
data class SendVerifyError (
    val type: ResSendVerifyErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResSendVerifyErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("ResendTooSoon") ResendTooSoon("ResendTooSoon"),
    @SerializedName("SendVerification") SendVerification("SendVerification"),
    @SerializedName("UserNotFound") UserNotFound("UserNotFound");
}
