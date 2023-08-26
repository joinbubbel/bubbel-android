// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json           = Json { allowStructuredMapKeys = true }
// val inUsernameToID = json.parse(InUsernameToID.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class InUsernameToID (
    val username: String
)
