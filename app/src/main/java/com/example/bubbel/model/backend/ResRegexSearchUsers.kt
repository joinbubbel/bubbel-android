// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                = Json { allowStructuredMapKeys = true }
// val resRegexSearchUsers = json.parse(ResRegexSearchUsers.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResRegexSearchUsers (
    val error: RegexSearchUsersError? = null,
    val res: RegexSearchUsersOut? = null
)

@Serializable
data class RegexSearchUsersError (
    val type: ResRegexSearchUsersErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResRegexSearchUsersErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("RegexLimit") RegexLimit("RegexLimit");
}

@Serializable
data class RegexSearchUsersOut (
    val users: List<List<User>>
)

@Serializable
sealed class User {
    class IntegerValue(val value: Long)  : User()
    class StringValue(val value: String) : User()
}
