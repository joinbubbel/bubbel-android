// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json              = Json { allowStructuredMapKeys = true }
// val resGetRandomUsers = json.parse(ResGetRandomUsers.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResGetRandomUsers (
    val error: GetRandomUsersError? = null,
    val res: GetRandomUsersOut? = null
)

@Serializable
data class GetRandomUsersError (
    val ierror: String,
    val type: Type
)

@Serializable
enum class ResGetRandomUsersErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal");
}

@Serializable
data class GetRandomUsersOut (
    val users: List<List<User>>
)

@Serializable
sealed class User {
    class IntegerValue(val value: Long)            : User()
    class UserProfileValue(val value: UserProfile) : User()
}

@Serializable
data class UserProfile (
    val banner: String? = null,
    val description: String? = null,

    @SerializedName("display_name")
    val displayName: String? = null,

    val name: String? = null,
    val pfp: String? = null,

    @SerializedName("user_id")
    val userID: Long
)
