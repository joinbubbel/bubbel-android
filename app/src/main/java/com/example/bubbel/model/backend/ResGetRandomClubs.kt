// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json              = Json { allowStructuredMapKeys = true }
// val resGetRandomClubs = json.parse(ResGetRandomClubs.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import java.lang.reflect.Type

@Serializable
data class ResGetRandomClubs (
    val error: GetRandomClubsError? = null,
    val res: GetRandomClubsOut? = null
)

@Serializable
data class GetRandomClubsError (
    val ierror: String,
    val type: Type
)

@Serializable
enum class ResGetRandomClubsErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal");
}

@Serializable
data class GetRandomClubsOut (
    val clubs: List<List<Club>>
)


@Serializable
data class ClubProfile (
    val banner: String? = null,
    val description: String? = null,

    @SerializedName("display_name")
    val displayName: String? = null,

    val name: String,
    val owner: Long,
    val pfp: String? = null
)
