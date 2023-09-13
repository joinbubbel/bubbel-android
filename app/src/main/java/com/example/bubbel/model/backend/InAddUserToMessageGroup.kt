import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                    = Json { allowStructuredMapKeys = true }
// val inAddUserToMessageGroup = json.parse(InAddUserToMessageGroup.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class InAddUserToMessageGroup (
    @SerializedName("add_user_id")
    val addUserID: Long,

    @SerializedName("message_group_id")
    val messageGroupID: Long,

    val token: String
)
