// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json             = Json { allowStructuredMapKeys = true }
// val inSetClubProfile = json.parse(InSetClubProfile.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class InSetClubProfile (
    val banner: String? = null,

    @SerializedName("club_id")
    val clubID: Long,

    val description: String? = null,

    @SerializedName("display_name")
    val displayName: String? = null,

    val name: String? = null,
    val owner: Long? = null,
    val pfp: String? = null,
    val token: String
)
