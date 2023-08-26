// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json          = Json { allowStructuredMapKeys = true }
// val resCreateUser = json.parse(ResCreateUser.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResCreateUser (
    val error: CreateUserError? = null,
    val res: CreateUserOut? = null
)

/**
 * Email is not valid by backend standards.
 *
 * Username is not valid by backend standards.
 *
 * Password is not valid by backend standards.
 *
 * Got an error from a cryptography function. This error should never occur.
 *
 * Email or Username already taken.
 */
@Serializable
data class CreateUserError (
    val type: ResCreateUserErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResCreateUserErrorType(val value: String) {
    @SerializedName("EmailOrUsernameTaken") EmailOrUsernameTaken("EmailOrUsernameTaken"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("InvalidEmail") InvalidEmail("InvalidEmail"),
    @SerializedName("InvalidPassword") InvalidPassword("InvalidPassword"),
    @SerializedName("InvalidPasswordCryto") InvalidPasswordCryto("InvalidPasswordCryto"),
    @SerializedName("InvalidUsername") InvalidUsername("InvalidUsername");
}

@Serializable
data class CreateUserOut (
    @SerializedName("user_id")
    val userID: Long
)
