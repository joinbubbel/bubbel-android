// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json             = Json { allowStructuredMapKeys = true }
// val inGetClubProfile = json.parse(InGetClubProfile.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
@Serializable
data class InGetClubProfile (
    @SerializedName("club_id")
    val clubID: Long,

    val token: String? = null
)
