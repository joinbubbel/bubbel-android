// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                = Json { allowStructuredMapKeys = true }
// val resRegexSearchClubs = json.parse(ResRegexSearchClubs.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResRegexSearchClubs (
    val error: RegexSearchClubsError? = null,
    val res: RegexSearchClubsOut? = null
)

@Serializable
data class RegexSearchClubsError (
    val type: ResRegexSearchClubsErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResRegexSearchClubsErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("RegexLimit") RegexLimit("RegexLimit");
}

@Serializable
data class RegexSearchClubsOut (
    val clubs: List<List<Club>>
)

@Serializable
sealed class Club {
    class IntegerValue(val value: Long)  : Club()
    class StringValue(val value: String) : Club()
}
