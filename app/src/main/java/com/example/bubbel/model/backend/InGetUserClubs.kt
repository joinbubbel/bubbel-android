// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json           = Json { allowStructuredMapKeys = true }
// val inGetUserClubs = json.parse(InGetUserClubs.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import com.google.gson.annotations.SerializedName

@Serializable
data class InGetUserClubs (
    @SerializedName("user_id")
    val userID: Long
)
